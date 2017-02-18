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
 * @author thoeger
 */
public class DeviceObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "DEVICE";
	
	private String path;
	
	private double activated;
	
	private String driver;
	
	private int bps;
	
	private EParity parity;
	
	private int stopbit;
	
	private boolean nativeMode;
	
	private double cycle;
	
	private double mincycle;
	
	/**
	 * Name the device for which the control bits are being reported
	 *
	 * @return the path
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * Name the device for which the control bits are being reported
	 *
	 * @param path the path to set
	 */
	public void setPath(final String path) {
		this.path = path;
	}
	
	/**
	 * Time the device was activated, or 0 if it is being closed.
	 *
	 * @return the activated
	 */
	public double getActivated() {
		return this.activated;
	}
	
	/**
	 * Time the device was activated, or 0 if it is being closed.
	 *
	 * @param activated the activated to set
	 */
	public void setActivated(final double activated) {
		this.activated = activated;
	}
	
	/**
	 * GPSD's name for the device driver type. Won't be reported before gpsd has seen identifiable packets from the device.
	 *
	 * @return the driver
	 */
	public String getDriver() {
		return this.driver;
	}
	
	/**
	 * GPSD's name for the device driver type. Won't be reported before gpsd has seen identifiable packets from the device.
	 *
	 * @param driver the driver to set
	 */
	public void setDriver(final String driver) {
		this.driver = driver;
	}
	
	/**
	 * Device speed in bits per second.
	 *
	 * @return the bps
	 */
	public int getBps() {
		return this.bps;
	}
	
	/**
	 * Device speed in bits per second.
	 *
	 * @param bps the bps to set
	 */
	public void setBps(final int bps) {
		this.bps = bps;
	}
	
	/**
	 * Device parity
	 *
	 * @return the parity
	 */
	public EParity getParity() {
		return this.parity;
	}
	
	/**
	 * Device parity
	 *
	 * @param parity the parity to set
	 */
	public void setParity(final EParity parity) {
		this.parity = parity;
	}
	
	/**
	 * Device Stopbits
	 *
	 * @return the stopbit
	 */
	public int getStopbit() {
		return this.stopbit;
	}
	
	/**
	 * Device Stopbits
	 *
	 * @param stopbit the stopbit to set
	 */
	public void setStopbit(final int stopbit) {
		this.stopbit = stopbit;
	}
	
	/**
	 * false means NMEA mode and true means alternate mode (binary if it has one, for SiRF and Evermore chipsets in particular).
	 *
	 * @return the nativeMode
	 */
	public boolean isNativeMode() {
		return this.nativeMode;
	}
	
	/**
	 * false means NMEA mode and true means alternate mode (binary if it has one, for SiRF and Evermore chipsets in particular).
	 *
	 * @param nativeMode the nativeMode to set
	 */
	public void setNativeMode(final boolean nativeMode) {
		this.nativeMode = nativeMode;
	}
	
	/**
	 * Device cycle time in seconds.
	 *
	 * @return the cycle
	 */
	public double getCycle() {
		return this.cycle;
	}
	
	/**
	 * Device cycle time in seconds.
	 *
	 * @param cycle the cycle to set
	 */
	public void setCycle(final double cycle) {
		this.cycle = cycle;
	}
	
	/**
	 * Device minimum cycle time in seconds.
	 *
	 * @return the mincycle
	 */
	public double getMincycle() {
		return this.mincycle;
	}
	
	/**
	 * Device minimum cycle time in seconds.
	 *
	 * @param mincycle the mincycle to set
	 */
	public void setMincycle(final double mincycle) {
		this.mincycle = mincycle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.activated);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + this.bps;
		temp = Double.doubleToLongBits(this.cycle);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + ((this.driver == null) ? 0 : this.driver.hashCode());
		temp = Double.doubleToLongBits(this.mincycle);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result) + (this.nativeMode ? 1231 : 1237);
		result = (prime * result) + ((this.parity == null) ? 0 : this.parity.hashCode());
		result = (prime * result) + ((this.path == null) ? 0 : this.path.hashCode());
		result = (prime * result) + this.stopbit;
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
		final DeviceObject other = (DeviceObject) obj;
		if (Double.doubleToLongBits(this.activated) != Double.doubleToLongBits(other.activated)) {
			return false;
		}
		if (this.bps != other.bps) {
			return false;
		}
		if (Double.doubleToLongBits(this.cycle) != Double.doubleToLongBits(other.cycle)) {
			return false;
		}
		if (this.driver == null) {
			if (other.driver != null) {
				return false;
			}
		} else if (!this.driver.equals(other.driver)) {
			return false;
		}
		if (Double.doubleToLongBits(this.mincycle) != Double.doubleToLongBits(other.mincycle)) {
			return false;
		}
		if (this.nativeMode != other.nativeMode) {
			return false;
		}
		if (this.parity != other.parity) {
			return false;
		}
		if (this.path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!this.path.equals(other.path)) {
			return false;
		}
		if (this.stopbit != other.stopbit) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("DeviceObject{path=");
		sb.append(this.path);
		sb.append(", driver=");
		sb.append(this.driver);
		sb.append(", activated=");
		sb.append((long) this.activated);
		sb.append(", bps=");
		sb.append(this.bps);
		sb.append(", parity=");
		sb.append(this.parity);
		sb.append(", stopbit=");
		sb.append(this.stopbit);
		sb.append(", nativeMode=");
		sb.append(this.nativeMode);
		sb.append(", cycle=");
		sb.append(this.cycle);
		sb.append(", minCycle=");
		sb.append(this.mincycle);
		sb.append("}");
		return sb.toString();
	}
	
}
