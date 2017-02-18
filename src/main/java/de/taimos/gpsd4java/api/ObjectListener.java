package de.taimos.gpsd4java.api;

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

import de.taimos.gpsd4java.types.ATTObject;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.subframes.SUBFRAMEObject;

/**
 * Adapter class for {@link IObjectListener}
 *
 * @author thoeger
 */
public class ObjectListener implements IObjectListener {
	
	@Override
	public void handleTPV(final TPVObject tpv) {
		// implement in subclass if needed
	}
	
	@Override
	public void handleSKY(final SKYObject sky) {
		// implement in subclass if needed
	}
	
	@Override
	public void handleATT(final ATTObject att) {
		// implement in subclass if needed
	}
	
	@Override
	public void handleSUBFRAME(final SUBFRAMEObject subframe) {
		// implement in subclass if needed
	}
	
	@Override
	public void handleDevices(final DevicesObject devices) {
		// implement in subclass if needed
	}
	
	@Override
	public void handleDevice(final DeviceObject device) {
		// implement in subclass if needed
	}
	
}
