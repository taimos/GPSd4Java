package de.taimos.gpsd4java.backend;

import de.taimos.gpsd4java.types.TPVObject;

/**
 * This class provides tools to measure the distance between two locations in
 * WGS84 coordinates
 * 
 * @author thoeger
 */
public class GISTool {
	
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
	 * calculates the distance between two locations, which are given as
	 * coordinates, in kilometers<br>
	 * the method used is the great-circle-distance with hypersine formula
	 * 
	 * @param x1 - longitude of position 1
	 * @param x2 - longitude of position 2
	 * @param y1 - latitude of position 1
	 * @param y2 - latitude of position 2
	 * @return distance in kilometers
	 */
	public static double getDistance(double x1, double x2, double y1, double y2) {
		// transform to radian
		x1 = x1 * (Math.PI / 180);
		x2 = x2 * (Math.PI / 180);
		y1 = y1 * (Math.PI / 180);
		y2 = y2 * (Math.PI / 180);
		// great-circle-distance with hypersine formula
		final double dlong = x1 - x2;
		final double dlat = y1 - y2;
		final double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(y1) * Math.cos(y2) * Math.pow(Math.sin(dlong / 2), 2);
		final double c = 2 * Math.asin(Math.sqrt(a));
		// Earth radius in kilometers
		return 6371 * c;
	}
	
}
