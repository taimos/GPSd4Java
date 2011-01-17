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

import de.taimos.gpsd4java.internal.backend.GPSdEndpoint;

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
		GPSdEndpoint ep = new GPSdEndpoint("192.168.1.115", 2947);
		ep.start();
		ep.watch(true);
	}
}
