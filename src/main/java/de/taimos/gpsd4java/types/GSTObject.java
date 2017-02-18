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
 * A GST object is a pseudorange noise report. <br>
 * all getters for double values may return <code>Double.NaN</code> if value is not present<br>
 * other getters may return <code>null</code>
 *
 * @author thoeger
 */
public class GSTObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "GST";
	
	private String tag = null;
	
	private String device = null;
	
	private double timestamp = Double.NaN;
	
	private double rms = Double.NaN;
	
	private double major = Double.NaN;
	
	private double minor = Double.NaN;
	
	private double orient = Double.NaN;
	
	private double lat = Double.NaN;
	
	private double lon = Double.NaN;
	
	private double alt = Double.NaN;
	
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
	 * Seconds since the Unix epoch, UTC. May have a fractional part of up to .001sec precision.
	 *
	 * @return the timestamp
	 */
	public double getTimestamp() {
		return this.timestamp;
	}
	
	/**
	 * Seconds since the Unix epoch, UTC. May have a fractional part of up to .001sec precision.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(final double timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Value of the standard deviation of the range inputs to the navigation process (range inputs include pseudoranges and DGPS
	 * corrections).
	 *
	 * @return the rms
	 */
	public double getRms() {
		return this.rms;
	}
	
	/**
	 * Value of the standard deviation of the range inputs to the navigation process (range inputs include pseudoranges and DGPS
	 * corrections).
	 *
	 * @param rms the rms to set
	 */
	public void setRms(final double rms) {
		this.rms = rms;
	}
	
	/**
	 * Standard deviation of semi-major axis of error ellipse, in meters.
	 *
	 * @return the major
	 */
	public double getMajor() {
		return this.major;
	}
	
	/**
	 * Standard deviation of semi-major axis of error ellipse, in meters.
	 *
	 * @param major the major to set
	 */
	public void setMajor(final double major) {
		this.major = major;
	}
	
	/**
	 * Standard deviation of semi-minor axis of error ellipse, in meters.
	 *
	 * @return the minor
	 */
	public double getMinor() {
		return this.minor;
	}
	
	/**
	 * Standard deviation of semi-minor axis of error ellipse, in meters.
	 *
	 * @param minor the minor to set
	 */
	public void setMinor(final double minor) {
		this.minor = minor;
	}
	
	/**
	 * Orientation of semi-major axis of error ellipse, in degrees from true north.
	 *
	 * @return the orient
	 */
	public double getOrient() {
		return this.orient;
	}
	
	/**
	 * Orientation of semi-major axis of error ellipse, in degrees from true north.
	 *
	 * @param orient the orient to set
	 */
	public void setOrient(final double orient) {
		this.orient = orient;
	}
	
	/**
	 * Standard deviation of latitude error, in meters.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return this.lat;
	}
	
	/**
	 * Standard deviation of latitude error, in meters.
	 *
	 * @param lat the lat to set
	 */
	public void setLat(final double lat) {
		this.lat = lat;
	}
	
	/**
	 * Standard deviation of longitude error, in meters.
	 *
	 * @return the lon
	 */
	public double getLon() {
		return this.lon;
	}
	
	/**
	 * Standard deviation of longitude error, in meters.
	 *
	 * @param lon the lon to set
	 */
	public void setLon(final double lon) {
		this.lon = lon;
	}
	
	/**
	 * Standard deviation of altitude error, in meters.
	 *
	 * @return the alt
	 */
	public double getAlt() {
		return this.alt;
	}
	
	/**
	 * Standard deviation of altitude error, in meters.
	 *
	 * @param alt the alt to set
	 */
	public void setAlt(final double alt) {
		this.alt = alt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.alt);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.device == null) ? 0 : this.device.hashCode());
		temp = Double.doubleToLongBits(this.lat);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.lon);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.major);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.minor);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.orient);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.rms);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.tag == null) ? 0 : this.tag.hashCode());
		temp = Double.doubleToLongBits(this.timestamp);
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
		final GSTObject other = (GSTObject) obj;
		if (Double.doubleToLongBits(this.alt) != Double.doubleToLongBits(other.alt)) {
			return false;
		}
		if (this.device == null) {
			if (other.device != null) {
				return false;
			}
		} else if (!this.device.equals(other.device)) {
			return false;
		}
		if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(other.lat)) {
			return false;
		}
		if (Double.doubleToLongBits(this.lon) != Double.doubleToLongBits(other.lon)) {
			return false;
		}
		if (Double.doubleToLongBits(this.major) != Double.doubleToLongBits(other.major)) {
			return false;
		}
		if (Double.doubleToLongBits(this.minor) != Double.doubleToLongBits(other.minor)) {
			return false;
		}
		if (Double.doubleToLongBits(this.orient) != Double.doubleToLongBits(other.orient)) {
			return false;
		}
		if (Double.doubleToLongBits(this.rms) != Double.doubleToLongBits(other.rms)) {
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
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("GSTObject{tag=");
		sb.append(this.tag);
		sb.append(", device=");
		sb.append(this.device);
		sb.append(", timestamp=");
		sb.append(this.timestamp);
		sb.append(", rms=");
		sb.append(this.rms);
		sb.append(", major=");
		sb.append(this.major);
		sb.append(", minor=");
		sb.append(this.minor);
		sb.append(", orient=");
		sb.append(this.orient);
		sb.append(", lat=");
		sb.append(this.lat);
		sb.append(", lon=");
		sb.append(this.lon);
		sb.append(", alt=");
		sb.append(this.alt);
		sb.append("}");
		return sb.toString();
	}
}
