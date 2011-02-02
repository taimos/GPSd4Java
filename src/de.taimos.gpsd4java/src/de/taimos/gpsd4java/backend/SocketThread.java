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
import java.net.SocketException;

/**
 * thread reading input from GPSd server
 * 
 * @author thoeger
 */
public class SocketThread extends Thread {
	
	private BufferedReader reader;
	
	private GPSdEndpoint endpoint;
	

	/**
	 * @param reader the socket input
	 * @param endpoint the endpoint
	 */
	public SocketThread(BufferedReader reader, GPSdEndpoint endpoint) {
		this.reader = reader;
		this.endpoint = endpoint;
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				// read line from socket
				String s = this.reader.readLine();
				if (s == null) {
					break;
				}
				if (!s.isEmpty()) {
					// parse line and handle it accordingly
					this.endpoint.handle(ResultParser.parse(s));
				}
			} catch (SocketException e) {
				// stop if socket fails
				break;
			} catch (Exception e) {
				// TODO handle this better
				e.printStackTrace();
			}
		}
	}
	
}
