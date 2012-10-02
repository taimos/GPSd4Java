/**
 * Copyright 2011 Thorsten Höger, Taimos GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.taimos.gpsd4java.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * thread reading input from GPSd server
 * 
 * @author thoeger
 */
public class SocketThread extends Thread {

	private static final Logger log = Logger.getLogger(SocketThread.class.getName());

	private final BufferedReader reader;

	private final GPSdEndpoint endpoint;

	private final AbstractResultParser resultParser;
	
	private boolean doRun = true;

	/**
	 * @param reader
	 *            the socket input
	 * @param endpoint
	 *            the endpoint
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
		while (doRun) {
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
				// stop if socket fails
				break;
			} catch (final Exception e) {
				// TODO handle this better
				log.log(Level.WARNING, null, e);
			}
		}
	}
	
	/**
	 * Halts the socket thread.
	 * @throws InterruptedException
	 */
	public void halt() throws InterruptedException {
		doRun = false;
		try {
			this.reader.close();
		} catch (IOException e) {
			//ignore
		}
		this.join(1000);
	}
}
