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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;

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
	}
	
	/**
	 * send WATCH command
	 * 
	 * @param enable enable/disable watch mode
	 */
	public void watch(boolean enable) {
		try {
			this.out.write("?WATCH={\"enable\":true,\"json\":true}");
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Poll GPSd for Message
	 * 
	 * @return {@link IGPSObject}
	 * @throws IOException on IO error in socket
	 * @throws ParseException on illegal response
	 */
	public IGPSObject poll() throws IOException, ParseException {
		this.out.write("?POLL;\n");
		this.out.flush();
		return ResultParser.parse(this.in.readLine());
	}
	
	// TODO implement rest of commands
	
	// ########################################################
	
	void handle(IGPSObject object) {
		// TODO handle response
		System.out.println(object);
	}
	
}
