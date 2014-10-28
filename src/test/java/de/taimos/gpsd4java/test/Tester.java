package de.taimos.gpsd4java.test;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	static final Logger log = LoggerFactory.getLogger(Tester.class);
	
	
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
					Tester.log.info("TPV: {}", tpv);
				}
				
				@Override
				public void handleSKY(final SKYObject sky) {
					Tester.log.info("SKY: {}", sky);
					for (final SATObject sat : sky.getSatellites()) {
						Tester.log.info("  SAT: {}", sat);
					}
				}
				
				@Override
				public void handleSUBFRAME(final SUBFRAMEObject subframe) {
					Tester.log.info("SUBFRAME: {}", subframe);
				}
				
				@Override
				public void handleATT(final ATTObject att) {
					Tester.log.info("ATT: {}", att);
				}
				
				@Override
				public void handleDevice(final DeviceObject device) {
					Tester.log.info("Device: {}", device);
				}
				
				@Override
				public void handleDevices(final DevicesObject devices) {
					for (final DeviceObject d : devices.getDevices()) {
						Tester.log.info("Device: {}", d);
					}
				}
			});
			
			ep.start();
			
			Tester.log.info("Version: {}", ep.version());
			
			Tester.log.info("Watch: {}", ep.watch(true, true));
			
			Tester.log.info("Poll: {}", ep.poll());
			
			Thread.sleep(60000);
		} catch (final Exception e) {
			Tester.log.error("Problem encountered", e);
		}
	}
}
