package de.taimos.gpsd4java.backend;

import de.taimos.gpsd4java.types.TPVObject;

/**
 * @author thoeger
 * 
 */
public class GISTool {
	
	/**
	 * @param c1
	 * @param c2
	 * @return distance in kilometers
	 */
	public static double getDistance(final TPVObject c1, final TPVObject c2) {
		return GISTool.getDistance(c1.getLongitude(), c2.getLongitude(), c1.getLatitude(), c2.getLatitude());
	}
	
	/**
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return distance in kilometers
	 */
	public static double getDistance(double x1, double x2, double y1, double y2) {
		x1 = x1 * (Math.PI / 180);
		x2 = x2 * (Math.PI / 180);
		y1 = y1 * (Math.PI / 180);
		y2 = y2 * (Math.PI / 180);
		final double dlong = x1 - x2;
		final double dlat = y1 - y2;
		final double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(y1) * Math.cos(y2) * Math.pow(Math.sin(dlong / 2), 2);
		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		// Earth radius in kilometers
		return 6367 * c;
	}
	
}
