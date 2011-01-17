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
package de.taimos.gpsd4java.internal.backend;

import java.io.BufferedReader;
import java.net.SocketException;

/**
 * thread reading input from GPSd server
 * 
 * created: 18.01.2011
 */
public class SocketThread extends Thread {
	
	private BufferedReader reader;
	
	private GPSdEndpoint endpoint;
	
	private boolean running = true;
	

	/**
	 * @param reader the socket input
	 * @param endpoint the endpoint
	 */
	public SocketThread(BufferedReader reader, GPSdEndpoint endpoint) {
		this.reader = reader;
		this.endpoint = endpoint;
	}
	
	@Override
	public void run() {
		while (this.running) {
			try {
				String s = this.reader.readLine();
				if (s == null) {
					break;
				}
				if (!s.isEmpty()) {
					this.endpoint.handle(ResultParser.parse(s));
				}
			} catch (SocketException e) {
				// e.printStackTrace();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
