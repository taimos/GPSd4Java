package de.taimos.gpsd4java.backend;

/*
 * #%L
 * GPSd4Java
 * %%
 * Copyright (C) 2011 - 2012 Taimos GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.taimos.gpsd4java.api.IObjectListener;
import de.taimos.gpsd4java.types.ATTObject;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.VersionObject;
import de.taimos.gpsd4java.types.WatchObject;
import de.taimos.gpsd4java.types.subframes.SUBFRAMEObject;

/**
 * GPSd client endpoint
 *
 * @author thoeger
 */
public class GPSdEndpoint {
	
	private static final Logger LOG = LoggerFactory.getLogger(GPSdEndpoint.class);
	
	private Socket socket;
	
	private BufferedReader in;
	
	private BufferedWriter out;
	
	private SocketThread listenThread;
	
	private final boolean daemon;
	
	private final List<IObjectListener> listeners = new ArrayList<IObjectListener>(1);
	
	private IGPSObject asyncResult = null;
	
	private final Object asyncMutex = new Object();
	
	private final Object asyncWaitMutex = new Object();
	
	private final AbstractResultParser resultParser;
	
	private String server;
	
	private int port;
	
	private String lastWatch;
	
	private AtomicLong retryInterval = new AtomicLong(1000);
	
	/**
	 * Instantiate this class to connect to a GPSd server
	 *
	 * @param server       the server name or IP
	 * @param port         the server port
	 * @param resultParser the result parser
	 * @param daemon       whether to start the underlying socket thread as a daemon, as defined in {@link Thread#setDaemon}  
	 */
	public GPSdEndpoint(final String server, final int port, final AbstractResultParser resultParser, final boolean daemon) {
		this.server = server;
		this.port = port;
		if (server == null) {
			throw new IllegalArgumentException("server can not be null!");
		}
		if ((port < 0) || (port > 65535)) {
			throw new IllegalArgumentException("Illegal port number: " + port);
		}
		if (resultParser == null) {
			throw new IllegalArgumentException("resultParser can not be null!");
		}

		this.resultParser = resultParser;
		
		this.daemon = daemon;
	}
	
	/**
	 * Instantiate this class to connect to a GPSd server
	 *
	 * @param server       the server name or IP
	 * @param port         the server port
	 * @param resultParser the result parser
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public GPSdEndpoint(final String server, final int port, final AbstractResultParser resultParser) throws UnknownHostException, IOException {
		this(server, port, resultParser, true);
	}
	
	/**
	 * Instantiate this class to connect to a GPSd server and use default parser
	 *
	 * @param server       the server name or IP
	 * @param port         the server port
	 */
	public GPSdEndpoint(final String server, final int port) {
		this(server, port, new ResultParser(), true);
	}
	
	/**
	 * start the endpoint
	 */
	public void start() {
		this.listenThread = new SocketThread(this.in, this, this.resultParser, this.daemon);
		this.listenThread.start();
	}
	
	/**
	 * Stops the endpoint.
	 */
	public void stop() {
		
		try {
			if (this.socket != null) {
				this.socket.close();
			}
		} catch (final IOException e1) {
			GPSdEndpoint.LOG.debug("Close forced: " + e1.getMessage());
		}
		
		this.listeners.clear();
		
		if (this.listenThread != null) {
			this.listenThread.halt();
		}
		
		this.listenThread = null;
	}
	
	/**
	 * send WATCH command
	 *
	 * @param enable   enable/disable watch mode
	 * @param dumpData enable/disable dumping of data
	 * @return {@link WatchObject}
	 * @throws IOException   on IO error in socket
	 * @throws JSONException
	 */
	public WatchObject watch(final boolean enable, final boolean dumpData) throws IOException, JSONException {
		return this.watch(enable, dumpData, null);
	}
	
	/**
	 * send WATCH command
	 *
	 * @param enable   enable/disable watch mode
	 * @param dumpData enable/disable dumping of data
	 * @param device   If present, enable watching only of the specified device rather than all devices
	 * @return {@link WatchObject}
	 * @throws IOException   on IO error in socket
	 * @throws JSONException
	 */
	public WatchObject watch(final boolean enable, final boolean dumpData, final String device) throws IOException, JSONException {
		JSONObject watch = new JSONObject();
		watch.put("class", "WATCH");
		watch.put("enable", enable);
		watch.put("json", dumpData);
		if (device != null) {
			watch.put("device", device);
		}
		return this.syncCommand("?WATCH=" + watch.toString(), WatchObject.class);
	}
	
	/**
	 * Poll GPSd for Message
	 *
	 * @return {@link PollObject}
	 * @throws IOException on IO error in socket
	 */
	public PollObject poll() throws IOException {
		return this.syncCommand("?POLL;", PollObject.class);
	}
	
	/**
	 * Poll GPSd version
	 *
	 * @return {@link VersionObject}
	 * @throws IOException on IO error in socket
	 */
	public VersionObject version() throws IOException {
		return this.syncCommand("?VERSION;", VersionObject.class);
	}
	
	// TODO implement rest of commands
	// ########################################################
	
	/**
	 * @param listener the listener to add
	 */
	public void addListener(final IObjectListener listener) {
		this.listeners.add(listener);
	}
	
	/**
	 * @param listener the listener to remove
	 */
	public void removeListener(final IObjectListener listener) {
		this.listeners.remove(listener);
	}
	
	// ########################################################
	
	/*
	 * send command to GPSd and wait for response
	 */
	private <T extends IGPSObject> T syncCommand(final String command, final Class<T> responseClass) throws IOException {
		synchronized (this.asyncMutex) {
			if (out != null) {
				this.out.write(command + "\n");
				this.out.flush();
			}
			if (responseClass == WatchObject.class) {
				lastWatch = command;
			}
			while (true) {
				// wait for awaited message
				// FIXME possible infinite loop if expected result arrives but new result overrides expected result before getting to this point.
				final IGPSObject result = this.waitForResult();
				if ((result == null) || result.getClass().equals(responseClass)) {
					return responseClass.cast(result);
				}
			}
		}
	}
	
	/*
	 * send command without response
	 */
	private void voidCommand(final String command) throws IOException {
		synchronized (this.asyncMutex) {
			this.out.write(command + "\n");
			this.out.flush();
		}
	}
	
	/*
	 * wait for a response for one second
	 */
	private IGPSObject waitForResult() {
		synchronized (this.asyncWaitMutex) {
			if (this.asyncResult == null) {
				try {
					this.asyncWaitMutex.wait(1000);
				} catch (final InterruptedException e) {
					GPSdEndpoint.LOG.info("Interrupted while waiting for result", e);
				}
			}
			final IGPSObject result = this.asyncResult;
			this.asyncResult = null;
			return result;
		}
	}
	
	/*
	 * handle incoming messages and dispatch them
	 */
	void handle(final IGPSObject object) {
		if (object instanceof TPVObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleTPV((TPVObject) object);
			}
		} else if (object instanceof SKYObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleSKY((SKYObject) object);
			}
		} else if (object instanceof ATTObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleATT((ATTObject) object);
			}
		} else if (object instanceof SUBFRAMEObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleSUBFRAME((SUBFRAMEObject) object);
			}
		} else if (object instanceof DevicesObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleDevices((DevicesObject) object);
			}
		} else if (object instanceof DeviceObject) {
			for (final IObjectListener l : this.listeners) {
				l.handleDevice((DeviceObject) object);
			}
		} else {
			// object was requested, so put it in the response object
			synchronized (this.asyncWaitMutex) {
				this.asyncResult = object;
				this.asyncWaitMutex.notifyAll();
			}
		}
	}
	
	/**
	 * Attempt to kick a failed device back into life on gpsd server.
	 * <p>
	 * see: https://lists.gnu.org/archive/html/gpsd-dev/2015-06/msg00001.html
	 *
	 * @param path Path of device known to gpsd
	 * @throws IOException
	 * @throws JSONException
	 */
	public void kickDevice(String path) throws IOException, JSONException {
		final JSONObject d = new JSONObject();
		d.put("class", "DEVICE");
		d.put("path", path);
		this.voidCommand("?DEVICE=" + d);
	}
	
	/**
	 * Our socket thread got disconnect and is exiting.
	 */
	void handleDisconnected() throws IOException {
		synchronized (this.asyncMutex) {
			if (socket != null) {
				socket.close();
			}
			this.socket = new Socket(server, port);
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			
			this.listenThread = new SocketThread(this.in, this, this.resultParser, this.daemon);
			this.listenThread.start();
			if (lastWatch != null) { // restore watch if we had one.
				this.syncCommand(lastWatch, WatchObject.class);
			}
		}
		
	}
	
	/**
	 * Set a retry interval for reconnecting to GPSD if the socket closes.
	 * Default value is 1000ms.
	 *
	 * @param millis how long to wait between each reconnection attempts.
	 */
	public void setRetryInterval(long millis) {
		retryInterval.set(millis);
	}
	
	/**
	 * Returns the retry interval for reconnecting to GPSD if the socket closes.
	 * Default value is 1000ms.
	 *
	 * @return retry interval
	 */
	public long getRetryInterval() {
		return retryInterval.get();
	}
	
}
