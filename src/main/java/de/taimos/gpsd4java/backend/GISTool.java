package de.taimos.gpsd4java.backend;

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

import de.taimos.gpsd4java.types.TPVObject;

/**
 * This class provides tools to measure the distance between two locations in WGS84 coordinates
 *
 * @author thoeger
 */
public final class GISTool {
	
	private static final int EARTH_RADIUS_KILOMETERS = 6371;
	
	private GISTool() {
		//
	}
	
	/**
	 * calculates the distance between two {@link TPVObject} in kilometers<br>
	 * the method used is the great-circle-distance with hypersine formula
	 *
	 * @param tpv1 - position 1
	 * @param tpv2 - position 2
	 * @return distance in kilometers
	 */
	public static double getDistance(final TPVObject tpv1, final TPVObject tpv2) {
		return GISTool.getDistance(tpv1.getLongitude(), tpv2.getLongitude(), tpv1.getLatitude(), tpv2.getLatitude());
	}
	
	/**
	 * calculates the distance between two locations, which are given as coordinates, in kilometers<br>
	 * the method used is the great-circle-distance with hypersine formula
	 *
	 * @param x1 - longitude of position 1
	 * @param x2 - longitude of position 2
	 * @param y1 - latitude of position 1
	 * @param y2 - latitude of position 2
	 * @return distance in kilometers
	 */
	public static double getDistance(final double x1, final double x2, final double y1, final double y2) {
		// transform to radian
		final double deg2rad = Math.PI / 180;
		
		final double x1rad = x1 * deg2rad;
		final double x2rad = x2 * deg2rad;
		final double y1rad = y1 * deg2rad;
		final double y2rad = y2 * deg2rad;
		
		// great-circle-distance with hypersine formula
		final double dlong = x1rad - x2rad;
		final double dlat = y1rad - y2rad;
		final double a = Math.pow(Math.sin(dlat / 2), 2) + (Math.cos(y1rad) * Math.cos(y2rad) * Math.pow(Math.sin(dlong / 2), 2));
		final double c = 2 * Math.asin(Math.sqrt(a));
		
		return GISTool.EARTH_RADIUS_KILOMETERS * c;
	}
	
}
