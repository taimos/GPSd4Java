/**
 * Copyright 2011 Thorsten Höger, Taimos GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.taimos.gpsd4java.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import de.taimos.gpsd4java.api.IObjectListener;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.VersionObject;
import de.taimos.gpsd4java.types.WatchObject;

/**
 * GPSd client endpoint
 * 
 * created: 17.01.2011
 */
public class GPSdEndpoint {
	
	private Socket socket;
	
	private BufferedReader in;
	private BufferedWriter out;
	
	private Thread listenThread;
	
	private List<IObjectListener> listeners = new ArrayList<IObjectListener>();
	
	private IGPSObject asnycResult = null;
	private Object asyncMutex = new Object();
	private Object asyncWaitMutex = new Object();
	

	/**
	 * @param server the server name or IP
	 * @param port the server port
	 */
	public GPSdEndpoint(String server, int port) {
		try {
			this.socket = new Socket(server, port);
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * start the endpoint
	 */
	public void start() {
		this.listenThread = new SocketThread(this.in, this);
		this.listenThread.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * send WATCH command
	 * 
	 * @param enable enable/disable watch mode
	 * @param dumpData enable/disable dumping of data
	 * @return {@link WatchObject}
	 * @throws IOException on IO error in socket
	 */
	public WatchObject watch(boolean enable, boolean dumpData) throws IOException {
		return this.watch(enable, dumpData, null);
	}
	
	/**
	 * send WATCH command
	 * 
	 * @param enable enable/disable watch mode
	 * @param dumpData enable/disable dumping of data
	 * @param device If present, enable watching only of the specified device
	 *            rather than all devices
	 * @return {@link WatchObject}
	 * @throws IOException on IO error in socket
	 */
	public WatchObject watch(boolean enable, boolean dumpData, String device) throws IOException {
		try {
			JSONObject watch = new JSONObject();
			watch.put("class", "WATCH");
			watch.put("enable", enable);
			watch.put("json", dumpData);
			if (device != null) {
				watch.put("device", device);
			}
			return this.syncCommand("?WATCH=" + watch.toString(), WatchObject.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Poll GPSd for Message
	 * 
	 * @return {@link PollObject}
	 * @throws IOException on IO error in socket
	 * @throws ParseException on illegal response
	 */
	public PollObject poll() throws IOException, ParseException {
		return this.syncCommand("?POLL;", PollObject.class);
	}
	
	/**
	 * Poll GPSd version
	 * 
	 * @return {@link VersionObject}
	 * @throws IOException on IO error in socket
	 * @throws ParseException on illegal response
	 */
	public VersionObject version() throws IOException, ParseException {
		return this.syncCommand("?VERSION;", VersionObject.class);
	}
	
	// TODO implement rest of commands
	
	// ########################################################
	
	/**
	 * @param listener the listener to add
	 */
	public void addListener(IObjectListener listener) {
		this.listeners.add(listener);
	}
	
	/**
	 * @param listener the listener to remove
	 */
	public void removeListener(IObjectListener listener) {
		this.listeners.remove(listener);
	}
	
	// ########################################################
	
	private <T extends IGPSObject> T syncCommand(String command, Class<T> responseClass) throws IOException {
		synchronized (this.asyncMutex) {
			this.out.write(command + "\n");
			this.out.flush();
			
			while (true) {
				// wait for awaited message
				IGPSObject result = this.waitForResult();
				if ((result == null) || result.getClass().equals(responseClass)) {
					return responseClass.cast(result);
				}
			}
		}
	}
	
	// will be used later on
	@SuppressWarnings("unused")
	private void voidCommand(String command) throws IOException {
		synchronized (this.asyncMutex) {
			this.out.write(command + "\n");
			this.out.flush();
		}
	}
	
	private IGPSObject waitForResult() {
		synchronized (this.asyncWaitMutex) {
			this.asnycResult = null;
			try {
				this.asyncWaitMutex.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (this.asnycResult != null) {
				return this.asnycResult;
			}
		}
		return null;
	}
	
	void handle(IGPSObject object) {
		if (object instanceof TPVObject) {
			for (IObjectListener l : this.listeners) {
				l.handleTPV((TPVObject) object);
			}
		} else if (object instanceof SKYObject) {
			for (IObjectListener l : this.listeners) {
				l.handleSKY((SKYObject) object);
			}
			// } else if (object instanceof ATTObject) {
			// for (IObjectListener l : this.listeners) {
			// l.handleATT((ATTObject) object);
			// }
		} else if (object instanceof DevicesObject) {
			for (IObjectListener l : this.listeners) {
				l.handleDevices((DevicesObject) object);
			}
		} else if (object instanceof DeviceObject) {
			for (IObjectListener l : this.listeners) {
				l.handleDevice((DeviceObject) object);
			}
		} else {
			synchronized (this.asyncWaitMutex) {
				this.asnycResult = object;
				this.asyncWaitMutex.notifyAll();
			}
		}
	}
}
