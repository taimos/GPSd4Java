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
 * An ATT object is a vehicle-attitude report. It is returned by digital-compass and gyroscope sensors; depending on device, it may include:
 * heading, pitch, roll, yaw, gyroscope, and magnetic-field readings. Because such sensors are often bundled as part of marine-navigation
 * systems, the ATT response may also include water depth.<br>
 * <br>
 * <p>
 * all getters for double values may return <code>Double.NaN</code> if value is not present<br>
 * other getters may return <code>null</code>
 *
 * @author thoeger
 */
public class ATTObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "ATT";
	
	private String tag = null;
	
	private String device = null;
	
	private double timestamp = Double.NaN;
	
	private double heading = Double.NaN;
	
	private double pitch = Double.NaN;
	
	private double yaw = Double.NaN;
	
	private double roll = Double.NaN;
	
	private double dip = Double.NaN;
	
	private double mag_len = Double.NaN;
	
	private double mag_x = Double.NaN;
	
	private double mag_y = Double.NaN;
	
	private double mag_z = Double.NaN;
	
	private double acc_len = Double.NaN;
	
	private double acc_x = Double.NaN;
	
	private double acc_y = Double.NaN;
	
	private double acc_z = Double.NaN;
	
	private double gyro_x = Double.NaN;
	
	private double gyro_y = Double.NaN;
	
	private double depth = Double.NaN;
	
	private double temperature = Double.NaN;
	
	private String magState = null;
	
	private String pitchState = null;
	
	private String yawState = null;
	
	private String rollState = null;
	
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
	 * Heading, degrees from true north.
	 *
	 * @return the heading
	 */
	public double getHeading() {
		return this.heading;
	}
	
	/**
	 * Heading, degrees from true north.
	 *
	 * @param heading the heading to set
	 */
	public void setHeading(final double heading) {
		this.heading = heading;
	}
	
	/**
	 * Pitch in degrees.
	 *
	 * @return the pitch
	 */
	public double getPitch() {
		return this.pitch;
	}
	
	/**
	 * Pitch in degrees.
	 *
	 * @param pitch the pitch to set
	 */
	public void setPitch(final double pitch) {
		this.pitch = pitch;
	}
	
	/**
	 * Yaw in degrees
	 *
	 * @return the yaw
	 */
	public double getYaw() {
		return this.yaw;
	}
	
	/**
	 * Yaw in degrees
	 *
	 * @param yaw the yaw to set
	 */
	public void setYaw(final double yaw) {
		this.yaw = yaw;
	}
	
	/**
	 * Roll in degrees.
	 *
	 * @return the roll
	 */
	public double getRoll() {
		return this.roll;
	}
	
	/**
	 * Roll in degrees.
	 *
	 * @param roll the roll to set
	 */
	public void setRoll(final double roll) {
		this.roll = roll;
	}
	
	/**
	 * Roll in degrees.
	 *
	 * @return the dip
	 */
	public double getDip() {
		return this.dip;
	}
	
	/**
	 * Roll in degrees.
	 *
	 * @param dip the dip to set
	 */
	public void setDip(final double dip) {
		this.dip = dip;
	}
	
	/**
	 * Scalar magnetic field strength.
	 *
	 * @return the mag_len
	 */
	public double getMag_len() {
		return this.mag_len;
	}
	
	/**
	 * Scalar magnetic field strength.
	 *
	 * @param mag_len the mag_len to set
	 */
	public void setMag_len(final double mag_len) {
		this.mag_len = mag_len;
	}
	
	/**
	 * X component of magnetic field strength.
	 *
	 * @return the mag_x
	 */
	public double getMag_x() {
		return this.mag_x;
	}
	
	/**
	 * X component of magnetic field strength.
	 *
	 * @param mag_x the mag_x to set
	 */
	public void setMag_x(final double mag_x) {
		this.mag_x = mag_x;
	}
	
	/**
	 * Y component of magnetic field strength.
	 *
	 * @return the mag_y
	 */
	public double getMag_y() {
		return this.mag_y;
	}
	
	/**
	 * Y component of magnetic field strength.
	 *
	 * @param mag_y the mag_y to set
	 */
	public void setMag_y(final double mag_y) {
		this.mag_y = mag_y;
	}
	
	/**
	 * Z component of magnetic field strength.
	 *
	 * @return the mag_z
	 */
	public double getMag_z() {
		return this.mag_z;
	}
	
	/**
	 * Z component of magnetic field strength.
	 *
	 * @param mag_z the mag_z to set
	 */
	public void setMag_z(final double mag_z) {
		this.mag_z = mag_z;
	}
	
	/**
	 * Scalar acceleration.
	 *
	 * @return the acc_len
	 */
	public double getAcc_len() {
		return this.acc_len;
	}
	
	/**
	 * Scalar acceleration.
	 *
	 * @param acc_len the acc_len to set
	 */
	public void setAcc_len(final double acc_len) {
		this.acc_len = acc_len;
	}
	
	/**
	 * X component of acceleration.
	 *
	 * @return the acc_x
	 */
	public double getAcc_x() {
		return this.acc_x;
	}
	
	/**
	 * X component of acceleration.
	 *
	 * @param acc_x the acc_x to set
	 */
	public void setAcc_x(final double acc_x) {
		this.acc_x = acc_x;
	}
	
	/**
	 * Y component of acceleration.
	 *
	 * @return the acc_y
	 */
	public double getAcc_y() {
		return this.acc_y;
	}
	
	/**
	 * Y component of acceleration.
	 *
	 * @param acc_y the acc_y to set
	 */
	public void setAcc_y(final double acc_y) {
		this.acc_y = acc_y;
	}
	
	/**
	 * Z component of acceleration.
	 *
	 * @return the acc_z
	 */
	public double getAcc_z() {
		return this.acc_z;
	}
	
	/**
	 * Z component of acceleration.
	 *
	 * @param acc_z the acc_z to set
	 */
	public void setAcc_z(final double acc_z) {
		this.acc_z = acc_z;
	}
	
	/**
	 * X component of acceleration.
	 *
	 * @return the gyro_x
	 */
	public double getGyro_x() {
		return this.gyro_x;
	}
	
	/**
	 * X component of acceleration.
	 *
	 * @param gyro_x the gyro_x to set
	 */
	public void setGyro_x(final double gyro_x) {
		this.gyro_x = gyro_x;
	}
	
	/**
	 * Y component of acceleration.
	 *
	 * @return the gyro_y
	 */
	public double getGyro_y() {
		return this.gyro_y;
	}
	
	/**
	 * Y component of acceleration.
	 *
	 * @param gyro_y the gyro_y to set
	 */
	public void setGyro_y(final double gyro_y) {
		this.gyro_y = gyro_y;
	}
	
	/**
	 * Water depth in meters.
	 *
	 * @return the depth
	 */
	public double getDepth() {
		return this.depth;
	}
	
	/**
	 * Water depth in meters.
	 *
	 * @param depth the depth to set
	 */
	public void setDepth(final double depth) {
		this.depth = depth;
	}
	
	/**
	 * Temperature at sensor, degrees centigrade.
	 *
	 * @return the temperature
	 */
	public double getTemperature() {
		return this.temperature;
	}
	
	/**
	 * Temperature at sensor, degrees centigrade.
	 *
	 * @param temperature the temperature to set
	 */
	public void setTemperature(final double temperature) {
		this.temperature = temperature;
	}
	
	/**
	 * Magnetometer status.
	 *
	 * @return the magState
	 */
	public String getMagState() {
		return this.magState;
	}
	
	/**
	 * Magnetometer status.
	 *
	 * @param magState the magState to set
	 */
	public void setMagState(final String magState) {
		this.magState = magState;
	}
	
	/**
	 * Pitch sensor status.
	 *
	 * @return the pitchState
	 */
	public String getPitchState() {
		return this.pitchState;
	}
	
	/**
	 * Pitch sensor status.
	 *
	 * @param pitchState the pitchState to set
	 */
	public void setPitchState(final String pitchState) {
		this.pitchState = pitchState;
	}
	
	/**
	 * Yaw sensor status.
	 *
	 * @return the yawState
	 */
	public String getYawState() {
		return this.yawState;
	}
	
	/**
	 * Yaw sensor status.
	 *
	 * @param yawState the yawState to set
	 */
	public void setYawState(final String yawState) {
		this.yawState = yawState;
	}
	
	/**
	 * Roll sensor status.
	 *
	 * @return the rollState
	 */
	public String getRollState() {
		return this.rollState;
	}
	
	/**
	 * Roll sensor status.
	 *
	 * @param rollState the rollState to set
	 */
	public void setRollState(final String rollState) {
		this.rollState = rollState;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ATTObject{tag=");
		sb.append(this.tag);
		sb.append(", device=");
		sb.append(this.device);
		sb.append(", timestamp=");
		sb.append(this.timestamp);
		sb.append(", heading=");
		sb.append(this.heading);
		sb.append(", mag_st=");
		sb.append(this.magState);
		sb.append(", pitch=");
		sb.append(this.pitch);
		sb.append(", pitch_st=");
		sb.append(this.pitchState);
		sb.append(", yaw=");
		sb.append(this.yawState);
		sb.append(", roll=");
		sb.append(this.roll);
		sb.append(", roll_st=");
		sb.append(this.rollState);
		sb.append(", dip=");
		sb.append(this.dip);
		sb.append(", mag_len=");
		sb.append(this.mag_len);
		sb.append(", mag_x=");
		sb.append(this.mag_x);
		sb.append(", mag_y=");
		sb.append(this.mag_y);
		sb.append(", mag_z=");
		sb.append(this.mag_z);
		sb.append(", acc_len=");
		sb.append(this.acc_len);
		sb.append(", acc_x=");
		sb.append(this.acc_x);
		sb.append(", acc_y=");
		sb.append(this.acc_y);
		sb.append(", acc_z=");
		sb.append(this.acc_z);
		sb.append(", gyro_x=");
		sb.append(this.gyro_x);
		sb.append(", gyro_y=");
		sb.append(this.gyro_y);
		sb.append(", depth=");
		sb.append(this.depth);
		sb.append(", temperature=");
		sb.append(this.temperature);
		sb.append("}");
		return sb.toString();
	}
}
