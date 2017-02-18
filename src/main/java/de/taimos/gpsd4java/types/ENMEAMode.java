package de.taimos.gpsd4java.types;

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

/**
 * NMEA Mode of GPSd response
 *
 * @author thoeger
 */
public enum ENMEAMode {
	
	/**
	 * no mode value yet seen
	 */
	NotSeen,
	/**
	 * No fix available
	 */
	NoFix,
	/**
	 * two dimensional fix
	 */
	TwoDimensional,
	/**
	 * three dimensional fix
	 */
	ThreeDimensional;
	
	/**
	 * @param mode - mode integer
	 * @return {@link ENMEAMode}
	 */
	public static ENMEAMode fromInt(final int mode) {
		switch (mode) {
		case 0:
			return NotSeen;
		case 1:
			return NoFix;
		case 2:
			return TwoDimensional;
		case 3:
			return ThreeDimensional;
		default:
			break;
		}
		return NotSeen;
	}
}
