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
package de.taimos.gpsd4java;

import de.taimos.gpsd4java.api.ObjectListener;
import de.taimos.gpsd4java.internal.backend.GPSdEndpoint;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.TPVObject;

/**
 * This class provides tests during the startup phase of GPSd4Java<br>
 * It will later be replaced by JUnit Tests
 * 
 * created: 17.01.2011
 * 
 */
public class Tester {
	
	/**
	 * @param args the args
	 */
	public static void main(String[] args) {
		try {
			GPSdEndpoint ep = new GPSdEndpoint("192.168.1.115", 2947);
			
			ep.addListener(new ObjectListener() {
				
				@Override
				public void handleTPV(TPVObject tpv) {
					System.out.println("Listener: " + tpv);
				}
				
				@Override
				public void handleDevices(DevicesObject devices) {
					for (DeviceObject d : devices.getDevices()) {
						System.out.println(d);
					}
				}
			});
			
			ep.start();
			
			System.out.println(ep.version());
			
			System.out.println(ep.watch(true, true));
			
			System.out.println("Polling...");
			PollObject poll = ep.poll();
			System.out.println(poll);
			for (TPVObject tpv : poll.getFixes()) {
				System.out.println(tpv);
			}
			System.out.println("...polling done");
			
			while (true) {
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
