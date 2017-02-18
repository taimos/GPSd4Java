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

import de.taimos.gpsd4java.backend.GISTool;
import de.taimos.gpsd4java.types.TPVObject;

/**
 * Derive this class to implement a listener for location updates which reacts to changes greater a given threshold
 *
 * @author thoeger
 */
public abstract class DistanceListener extends ObjectListener {
	
	private TPVObject lastPosition;
	
	private final double threshold;
	
	/**
	 * @param threshold the threshold to fire in kilometers
	 */
	public DistanceListener(final double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void handleTPV(final TPVObject tpv) {
		if ((this.lastPosition == null) || (GISTool.getDistance(tpv, this.lastPosition) > this.threshold)) {
			this.lastPosition = tpv;
			this.handleLocation(tpv);
		}
	}
	
	protected abstract void handleLocation(TPVObject tpv);
	
}
