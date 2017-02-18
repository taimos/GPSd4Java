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
import java.io.IOException;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * thread reading input from GPSd server
 *
 * @author thoeger
 */
public class SocketThread extends Thread {
	
	private static final Logger LOG = LoggerFactory.getLogger(SocketThread.class);
	
	private final BufferedReader reader;
	
	private final GPSdEndpoint endpoint;
	
	private final AbstractResultParser resultParser;
	
	private final WaitableBoolean running = new WaitableBoolean(true);
	
	/**
	 * @param reader       the socket input
	 * @param endpoint     the endpoint
	 * @param resultParser
	 */
	public SocketThread(final BufferedReader reader, final GPSdEndpoint endpoint, final AbstractResultParser resultParser) {
		if (reader == null) {
			throw new IllegalArgumentException("reader can not be null!");
		}
		if (endpoint == null) {
			throw new IllegalArgumentException("endpoint can not be null!");
		}
		if (resultParser == null) {
			throw new IllegalArgumentException("resultParser can not be null!");
		}
		
		this.reader = reader;
		this.endpoint = endpoint;
		this.resultParser = resultParser;
		
		this.setDaemon(true);
		this.setName("GPS Socket Thread");
	}
	
	@Override
	public void run() {
		while (this.running.get()) {
			try {
				// read line from socket
				final String s = this.reader.readLine();
				if (s == null) {
					break;
				}
				if (!s.isEmpty()) {
					// parse line and handle it accordingly
					this.endpoint.handle(this.resultParser.parse(s));
				}
			} catch (final SocketException e) {
				break; // stop 
			} catch (final Exception e) {
				// TODO handle this better
				SocketThread.LOG.warn("Problem encountered while reading/parsing/handling line", e);
			}
		}
		if (running.get() && !Thread.interrupted()) {
			SocketThread.LOG.warn("Problem encountered while reading/parsing/handling line, attempting restart");
			retry();
		}
	}
	
	protected void retry() {
		SocketThread.LOG.debug("Disconnected from GPS socket, retrying connection");
		
		while (this.running.get()) {
			try {
				running.waitFor(1000);
				this.endpoint.handleDisconnected();
				SocketThread.LOG.debug("Reconnected to GPS socket");
				running.set(false);
			} catch (InterruptedException ix) {
				break;
			} catch (IOException e) {
				SocketThread.LOG.debug("Still disconnected from GPS socket, retrying connection again");
			}
		}
	}
	
	/**
	 * Halts the socket thread.
	 *
	 * @throws InterruptedException
	 */
	public void halt() throws InterruptedException {
		this.running.set(false);
		try {
			this.reader.close();
		} catch (final IOException e) {
			// ignore
		}
		this.join(1000);
	}
}