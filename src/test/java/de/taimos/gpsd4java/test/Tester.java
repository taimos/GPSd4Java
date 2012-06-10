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
package de.taimos.gpsd4java.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import de.taimos.gpsd4java.api.ObjectListener;
import de.taimos.gpsd4java.backend.GPSdEndpoint;
import de.taimos.gpsd4java.backend.ResultParser;
import de.taimos.gpsd4java.types.ATTObject;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.SATObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.subframes.SUBFRAMEObject;

/**
 * This class provides tests during the startup phase of GPSd4Java<br>
 * It will later be replaced by JUnit Tests
 * 
 * created: 17.01.2011
 * 
 */
public class Tester {

	static final Logger log = Logger.getLogger(Tester.class.getName());

	private Tester() {
	}

	/**
	 * @param args
	 *            the args
	 */
	public static void main(final String[] args) {
		try {
			String host = "localhost";
			int port = 2947;

			switch (args.length) {
			case 0:
				// Nothing to do, use default
				break;
			case 1:
				// only server specified
				host = args[0];
				break;
			case 2:
				// Server and port specified
				host = args[0];
				if (args[1].matches("\\d+")) {
					port = Integer.parseInt(args[1]);
				}
				break;
			default:
				break;
			}

			final GPSdEndpoint ep = new GPSdEndpoint(host, port, new ResultParser());

			ep.addListener(new ObjectListener() {

				@Override
				public void handleTPV(final TPVObject tpv) {
					Tester.log.log(Level.INFO, "TPV: {0}", tpv);
				}

				@Override
				public void handleSKY(SKYObject sky) {
					Tester.log.log(Level.INFO, "SKY: {0}", sky);
					for (final SATObject sat : sky.getSatellites()) {
						Tester.log.log(Level.INFO, "  SAT: {0}", sat);
					}
				}

				@Override
				public void handleSUBFRAME(SUBFRAMEObject subframe) {
					Tester.log.log(Level.INFO, "SUBFRAME: {0}", subframe);
				}

				@Override
				public void handleATT(ATTObject att) {
					Tester.log.log(Level.INFO, "ATT: {0}", att);
				}

				@Override
				public void handleDevice(DeviceObject device) {
					Tester.log.log(Level.INFO, "Device: {0}", device);
				}

				@Override
				public void handleDevices(final DevicesObject devices) {
					for (final DeviceObject d : devices.getDevices()) {
						Tester.log.log(Level.INFO, "Device: {0}", d);
					}
				}
			});

			ep.start();

			Tester.log.log(Level.INFO, "Version: {0}", ep.version());

			Tester.log.log(Level.INFO, "Watch: {0}", ep.watch(true, false));

			Tester.log.log(Level.INFO, "Poll: {0}", ep.poll());

			Thread.sleep(60000);
		} catch (final Exception e) {
			Tester.log.log(Level.SEVERE, null, e);
		}
	}
}
