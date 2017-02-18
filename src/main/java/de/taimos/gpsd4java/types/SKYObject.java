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

import java.util.List;

/**
 * @author thoeger
 * @author aevdokimov
 */
public class SKYObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "SKY";
	
	private String tag = null;
	
	private String device = null;
	
	private double timestamp = Double.NaN;
	
	private double longitudeDOP = Double.NaN;
	
	private double latitudeDOP = Double.NaN;
	
	private double altitudeDOP = Double.NaN;
	
	private double timestampDOP = Double.NaN;
	
	private double horizontalDOP = Double.NaN;
	
	private double sphericalDOP = Double.NaN;
	
	private double hypersphericalDOP = Double.NaN;
	
	private List<SATObject> satellites;
	
	/**
	 * Type tag associated with this GPS sentence; from an NMEA device this is just the NMEA sentence type.
	 *
	 * @return the tag
	 */
	public String getTag() {
		return this.tag;
	}
	
	/**
	 * Type tag associated with this GPS sentence; from an NMEA device this is just the NMEA sentence type.
	 *
	 * @param tag the tag to set
	 */
	public void setTag(final String tag) {
		this.tag = tag;
	}
	
	/**
	 * Name of originating device
	 *
	 * @return the device
	 */
	public String getDevice() {
		return this.device;
	}
	
	/**
	 * Name of originating device
	 *
	 * @param device the device to set
	 */
	public void setDevice(final String device) {
		this.device = device;
	}
	
	/**
	 * Seconds since the Unix epoch, UTC. May have a fractional part of up to .01sec precision.
	 *
	 * @return the timestamp
	 */
	public double getTimestamp() {
		return this.timestamp;
	}
	
	/**
	 * Seconds since the Unix epoch, UTC. May have a fractional part of up to .01sec precision.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(final double timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Longitudinal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the longitude DOP
	 */
	public double getLongitudeDOP() {
		return this.longitudeDOP;
	}
	
	/**
	 * Longitudinal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param longitudeDOP the longitude DOP to set
	 */
	public void setLongitudeDOP(final double longitudeDOP) {
		this.longitudeDOP = longitudeDOP;
	}
	
	/**
	 * Latitudinal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the latitude DOP
	 */
	public double getLatitudeDOP() {
		return this.latitudeDOP;
	}
	
	/**
	 * Latitudinal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param latitudeDOP the latitude DOP to set
	 */
	public void setLatitudeDOP(final double latitudeDOP) {
		this.latitudeDOP = latitudeDOP;
	}
	
	/**
	 * Altitude dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the altitude DOP
	 */
	public double getAltitudeDOP() {
		return this.altitudeDOP;
	}
	
	/**
	 * Altitude dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param altitudeDOP the altitude DOP to set
	 */
	public void setAltitudeDOP(final double altitudeDOP) {
		this.altitudeDOP = altitudeDOP;
	}
	
	/**
	 * Time dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the timestamp DOP
	 */
	public double getTimestampDOP() {
		return this.timestampDOP;
	}
	
	/**
	 * Time dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param timestampDOP the timestamp DOP to set
	 */
	public void setTimestampDOP(final double timestampDOP) {
		this.timestampDOP = timestampDOP;
	}
	
	/**
	 * Horizontal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get a circular error estimate.
	 *
	 * @return the horizontal DOP
	 */
	public double getHorizontalDOP() {
		return this.horizontalDOP;
	}
	
	/**
	 * Horizontal dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get a circular error estimate.
	 *
	 * @param horizontalDOP the horizontal DOP to set
	 */
	public void setHorizontalDOP(final double horizontalDOP) {
		this.horizontalDOP = horizontalDOP;
	}
	
	/**
	 * Spherical dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the spherical DOP
	 */
	public double getSphericalDOP() {
		return this.sphericalDOP;
	}
	
	/**
	 * Spherical dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param sphericalDOP the spherical DOP to set
	 */
	public void setSphericalDOP(final double sphericalDOP) {
		this.sphericalDOP = sphericalDOP;
	}
	
	/**
	 * Hyperspherical dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @return the hyperspherical DOP
	 */
	public double getHypersphericalDOP() {
		return this.hypersphericalDOP;
	}
	
	/**
	 * Hyperspherical dilution of precision, a dimensionless factor which should be multiplied by a base UERE to get an error estimate.
	 *
	 * @param hypersphericalDOP the hyperspherical DOP to set
	 */
	public void setHypersphericalDOP(final double hypersphericalDOP) {
		this.hypersphericalDOP = hypersphericalDOP;
	}
	
	/**
	 * list of Satellite objects
	 *
	 * @return the satellites
	 */
	public List<SATObject> getSatellites() {
		return this.satellites;
	}
	
	/**
	 * list of Satellite objects
	 *
	 * @param satellites the satellites to set
	 */
	public void setSatellites(final List<SATObject> satellites) {
		this.satellites = satellites;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.altitudeDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.device == null) ? 0 : this.device.hashCode());
		temp = Double.doubleToLongBits(this.horizontalDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.hypersphericalDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.latitudeDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.longitudeDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.sphericalDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.tag == null) ? 0 : this.tag.hashCode());
		temp = Double.doubleToLongBits(this.timestamp);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.timestampDOP);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final SKYObject other = (SKYObject) obj;
		if (Double.doubleToLongBits(this.altitudeDOP) != Double.doubleToLongBits(other.altitudeDOP)) {
			return false;
		}
		if (this.device == null) {
			if (other.device != null) {
				return false;
			}
		} else if (!this.device.equals(other.device)) {
			return false;
		}
		if (Double.doubleToLongBits(this.horizontalDOP) != Double.doubleToLongBits(other.horizontalDOP)) {
			return false;
		}
		if (Double.doubleToLongBits(this.hypersphericalDOP) != Double.doubleToLongBits(other.hypersphericalDOP)) {
			return false;
		}
		if (Double.doubleToLongBits(this.latitudeDOP) != Double.doubleToLongBits(other.latitudeDOP)) {
			return false;
		}
		if (Double.doubleToLongBits(this.longitudeDOP) != Double.doubleToLongBits(other.longitudeDOP)) {
			return false;
		}
		if (Double.doubleToLongBits(this.sphericalDOP) != Double.doubleToLongBits(other.sphericalDOP)) {
			return false;
		}
		if (this.tag == null) {
			if (other.tag != null) {
				return false;
			}
		} else if (!this.tag.equals(other.tag)) {
			return false;
		}
		if (Double.doubleToLongBits(this.timestamp) != Double.doubleToLongBits(other.timestamp)) {
			return false;
		}
		if (Double.doubleToLongBits(this.timestampDOP) != Double.doubleToLongBits(other.timestampDOP)) {
			return false;
		}
		if (this.satellites.size() != other.satellites.size()) {
			return false;
		}
		try {
			for (int i = 0; i < this.satellites.size(); i++) {
				if (!this.satellites.get(i).equals(other.satellites.get(i))) {
					return false;
				}
			}
		} catch (final IndexOutOfBoundsException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("SKYObject{time=");
		sb.append(this.timestamp);
		sb.append(", xdop=");
		sb.append(this.longitudeDOP);
		sb.append(", ydop=");
		sb.append(this.latitudeDOP);
		sb.append(", vdop=");
		sb.append(this.altitudeDOP);
		sb.append(", tdop=");
		sb.append(this.timestampDOP);
		sb.append(", hdop=");
		sb.append(this.horizontalDOP);
		sb.append(", pdop=");
		sb.append(this.sphericalDOP);
		sb.append(", gdop=");
		sb.append(this.hypersphericalDOP);
		sb.append(", sat=");
		sb.append(this.satellites == null ? 0 : this.satellites.size());
		sb.append("}");
		
		return sb.toString();
	}
	
}
