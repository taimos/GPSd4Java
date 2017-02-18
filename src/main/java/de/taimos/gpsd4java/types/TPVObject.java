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
 * Time-Position-Velocity Report Object<br>
 * <br>
 * all getters for double values may return <code>Double.NaN</code> if value is not present<br>
 * other getters may return <code>null</code>
 *
 * @author thoeger
 */
public class TPVObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "TPV";
	
	private String tag = null;
	
	private String device = null;
	
	private double timestamp = Double.NaN;
	
	private double timestampError = Double.NaN;
	
	private double latitude = Double.NaN;
	
	private double longitude = Double.NaN;
	
	private double altitude = Double.NaN;
	
	private double latitudeError = Double.NaN;
	
	private double longitudeError = Double.NaN;
	
	private double altitudeError = Double.NaN;
	
	private double course = Double.NaN;
	
	private double speed = Double.NaN;
	
	private double climbRate = Double.NaN;
	
	private double courseError = Double.NaN;
	
	private double speedError = Double.NaN;
	
	private double climbRateError = Double.NaN;
	
	private ENMEAMode mode;
	
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
	 * Estimated timestamp error (%f, seconds, 95% confidence).
	 *
	 * @return the timestampError
	 */
	public double getTimestampError() {
		return this.timestampError;
	}
	
	/**
	 * Estimated timestamp error (%f, seconds, 95% confidence).
	 *
	 * @param timestampError the timestampError to set
	 */
	public void setTimestampError(final double timestampError) {
		this.timestampError = timestampError;
	}
	
	/**
	 * Latitude in degrees: +/- signifies North/South
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * Latitude in degrees: +/- signifies North/South
	 *
	 * @param latitude the latitude to set
	 */
	public void setLatitude(final double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Longitude in degrees: +/- signifies East/West
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * Longitude in degrees: +/- signifies East/West
	 *
	 * @param longitude the longitude to set
	 */
	public void setLongitude(final double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Altitude in meters.
	 *
	 * @return the altitude
	 */
	public double getAltitude() {
		return this.altitude;
	}
	
	/**
	 * Altitude in meters.
	 *
	 * @param altitude the altitude to set
	 */
	public void setAltitude(final double altitude) {
		this.altitude = altitude;
	}
	
	/**
	 * Latitude error estimate in meters, 95% confidence.
	 *
	 * @return the latitudeError
	 */
	public double getLatitudeError() {
		return this.latitudeError;
	}
	
	/**
	 * Latitude error estimate in meters, 95% confidence.
	 *
	 * @param latitudeError the latitudeError to set
	 */
	public void setLatitudeError(final double latitudeError) {
		this.latitudeError = latitudeError;
	}
	
	/**
	 * Longitude error estimate in meters, 95% confidence.
	 *
	 * @return the longitudeError
	 */
	public double getLongitudeError() {
		return this.longitudeError;
	}
	
	/**
	 * Longitude error estimate in meters, 95% confidence.
	 *
	 * @param longitudeError the longitudeError to set
	 */
	public void setLongitudeError(final double longitudeError) {
		this.longitudeError = longitudeError;
	}
	
	/**
	 * Estimated vertical error in meters, 95% confidence.
	 *
	 * @return the altitudeError
	 */
	public double getAltitudeError() {
		return this.altitudeError;
	}
	
	/**
	 * Estimated vertical error in meters, 95% confidence.
	 *
	 * @param altitudeError the altitudeError to set
	 */
	public void setAltitudeError(final double altitudeError) {
		this.altitudeError = altitudeError;
	}
	
	/**
	 * Course over ground, degrees from true north.
	 *
	 * @return the course
	 */
	public double getCourse() {
		return this.course;
	}
	
	/**
	 * Course over ground, degrees from true north.
	 *
	 * @param course the course to set
	 */
	public void setCourse(final double course) {
		this.course = course;
	}
	
	/**
	 * Speed over ground, meters per second.
	 *
	 * @return the speed
	 */
	public double getSpeed() {
		return this.speed;
	}
	
	/**
	 * Speed over ground, meters per second.
	 *
	 * @param speed the speed to set
	 */
	public void setSpeed(final double speed) {
		this.speed = speed;
	}
	
	/**
	 * Climb (positive) or sink (negative) rate, meters per second.
	 *
	 * @return the climbRate
	 */
	public double getClimbRate() {
		return this.climbRate;
	}
	
	/**
	 * Climb (positive) or sink (negative) rate, meters per second.
	 *
	 * @param climbRate the climbRate to set
	 */
	public void setClimbRate(final double climbRate) {
		this.climbRate = climbRate;
	}
	
	/**
	 * Direction error estimate in degrees, 95% confidence.
	 *
	 * @return the courseError
	 */
	public double getCourseError() {
		return this.courseError;
	}
	
	/**
	 * Direction error estimate in degrees, 95% confidence.
	 *
	 * @param courseError the courseError to set
	 */
	public void setCourseError(final double courseError) {
		this.courseError = courseError;
	}
	
	/**
	 * Speed error estimate in meters/sec, 95% confidence.
	 *
	 * @return the speedError
	 */
	public double getSpeedError() {
		return this.speedError;
	}
	
	/**
	 * Speed error estimate in meters/sec, 95% confidence.
	 *
	 * @param speedError the speedError to set
	 */
	public void setSpeedError(final double speedError) {
		this.speedError = speedError;
	}
	
	/**
	 * Climb/sink error estimate in meters/sec, 95% confidence.
	 *
	 * @return the climbRateError
	 */
	public double getClimbRateError() {
		return this.climbRateError;
	}
	
	/**
	 * Climb/sink error estimate in meters/sec, 95% confidence.
	 *
	 * @param climbRateError the climbRateError to set
	 */
	public void setClimbRateError(final double climbRateError) {
		this.climbRateError = climbRateError;
	}
	
	/**
	 * NMEA mode
	 *
	 * @return the mode
	 */
	public ENMEAMode getMode() {
		return this.mode;
	}
	
	/**
	 * NMEA mode
	 *
	 * @param mode the mode to set
	 */
	public void setMode(final ENMEAMode mode) {
		this.mode = mode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.altitude);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.altitudeError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.climbRate);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.climbRateError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.course);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.courseError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.device == null) ? 0 : this.device.hashCode());
		temp = Double.doubleToLongBits(this.latitude);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.latitudeError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.longitude);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.longitudeError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.mode == null) ? 0 : this.mode.hashCode());
		temp = Double.doubleToLongBits(this.speed);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.speedError);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.tag == null) ? 0 : this.tag.hashCode());
		temp = Double.doubleToLongBits(this.timestamp);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.timestampError);
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
		final TPVObject other = (TPVObject) obj;
		if (Double.doubleToLongBits(this.altitude) != Double.doubleToLongBits(other.altitude)) {
			return false;
		}
		if (Double.doubleToLongBits(this.altitudeError) != Double.doubleToLongBits(other.altitudeError)) {
			return false;
		}
		if (Double.doubleToLongBits(this.climbRate) != Double.doubleToLongBits(other.climbRate)) {
			return false;
		}
		if (Double.doubleToLongBits(this.climbRateError) != Double.doubleToLongBits(other.climbRateError)) {
			return false;
		}
		if (Double.doubleToLongBits(this.course) != Double.doubleToLongBits(other.course)) {
			return false;
		}
		if (Double.doubleToLongBits(this.courseError) != Double.doubleToLongBits(other.courseError)) {
			return false;
		}
		if (this.device == null) {
			if (other.device != null) {
				return false;
			}
		} else if (!this.device.equals(other.device)) {
			return false;
		}
		if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
			return false;
		}
		if (Double.doubleToLongBits(this.latitudeError) != Double.doubleToLongBits(other.latitudeError)) {
			return false;
		}
		if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
			return false;
		}
		if (Double.doubleToLongBits(this.longitudeError) != Double.doubleToLongBits(other.longitudeError)) {
			return false;
		}
		if (this.mode != other.mode) {
			return false;
		}
		if (Double.doubleToLongBits(this.speed) != Double.doubleToLongBits(other.speed)) {
			return false;
		}
		if (Double.doubleToLongBits(this.speedError) != Double.doubleToLongBits(other.speedError)) {
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
		if (Double.doubleToLongBits(this.timestampError) != Double.doubleToLongBits(other.timestampError)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("TPVObject{tag=");
		sb.append(this.tag);
		sb.append(", device=");
		sb.append(this.device);
		sb.append(", timestamp=");
		sb.append(this.timestamp);
		sb.append(", timestampError=");
		sb.append(this.timestampError);
		sb.append(", latitude=");
		sb.append(this.latitude);
		sb.append(", longitude=");
		sb.append(this.longitude);
		sb.append(", altitude=");
		sb.append(this.altitude);
		sb.append(", latitudeError=");
		sb.append(this.latitudeError);
		sb.append(", longitudeError=");
		sb.append(this.longitudeError);
		sb.append(", altitudeError=");
		sb.append(this.altitudeError);
		sb.append(", course=");
		sb.append(this.course);
		sb.append(", speed=");
		sb.append(this.speed);
		sb.append(", climbRate=");
		sb.append(this.climbRate);
		sb.append(", courseError=");
		sb.append(this.courseError);
		sb.append(", speedError=");
		sb.append(this.speedError);
		sb.append(", climbRateError=");
		sb.append(this.climbRateError);
		if (mode != null) {
			sb.append(", mode=");
			sb.append(this.mode.name());
		}
		sb.append("}");
		return sb.toString();
	}
	
}
