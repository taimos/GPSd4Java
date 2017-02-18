package de.taimos.gpsd4java.types.subframes;

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

import de.taimos.gpsd4java.types.IGPSObject;

/**
 * @author aevdokimov
 */
public class SUBFRAMEObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "SUBFRAME";
	
	private String device = null;
	
	private int subframeNumber = -1;
	
	private int satelliteNumber = -1;
	
	private int MSBs = -1;
	
	private boolean scaled = false;
	
	private int pageid = -1;
	
	private String systemMessage = null;
	
	private ALMANACObject almanac;
	
	private EPHEM1Object ephem1;
	
	private EPHEM2Object ephem2;
	
	private EPHEM3Object ephem3;
	
	private ERDObject erd;
	
	private HEALTHObject health;
	
	private HEALTH2Object health2;
	
	private IONOObject iono;
	
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
	 * Subframe number
	 *
	 * @return the subframe number
	 */
	public int getSubFrameNumber() {
		return this.subframeNumber;
	}
	
	/**
	 * Subframe number
	 *
	 * @param subframeNumber to set
	 */
	public void setSubframeNumber(final int subframeNumber) {
		this.subframeNumber = subframeNumber;
	}
	
	/**
	 * Satellite number
	 *
	 * @return the satellite number
	 */
	public int getSatelliteNumber() {
		return this.satelliteNumber;
	}
	
	/**
	 * Satellite number
	 *
	 * @param satelliteNumber satellite number to set
	 */
	public void setSatelliteNumber(final int satelliteNumber) {
		this.satelliteNumber = satelliteNumber;
	}
	
	/**
	 * TOW17 field containing the 17 MSBs of the start of the next 12-second message
	 *
	 * @return TOW17
	 */
	public int getMSBs() {
		return this.MSBs;
	}
	
	/**
	 * TOW17 field containing the 17 MSBs of the start of the next 12-second message
	 *
	 * @param MSBs TOW17 to set
	 */
	public void setMSBs(final int MSBs) {
		this.MSBs = MSBs;
	}
	
	/**
	 * field telling whether the remainder of the fields are dumped in scaled or unscaled form
	 *
	 * @return scaled
	 */
	public boolean getScaled() {
		return this.scaled;
	}
	
	/**
	 * field telling whether the remainder of the fields are dumped in scaled or unscaled form
	 *
	 * @param scaled scaled to set
	 */
	public void setScaled(final boolean scaled) {
		this.scaled = scaled;
	}
	
	/**
	 * optional pageid for ERD, IONO, HEALTH and system message
	 *
	 * @return pageid
	 */
	public int getPageid() {
		return this.pageid;
	}
	
	/**
	 * optional pageid for ERD, IONO, HEALTH and system message
	 *
	 * @param pageid page id to set
	 */
	public void setPageid(final int pageid) {
		this.pageid = pageid;
	}
	
	/**
	 * optional system message
	 *
	 * @return system message
	 */
	public String getSystemMessage() {
		return this.systemMessage;
	}
	
	/**
	 * optional system message
	 *
	 * @param systemMessage system message to set
	 */
	public void setSystemMessage(final String systemMessage) {
		this.systemMessage = systemMessage;
	}
	
	/**
	 * Optional ALMANAC object
	 *
	 * @return ALMANAC
	 */
	public ALMANACObject getAlmanac() {
		return this.almanac;
	}
	
	/**
	 * Optional ALMANAC object
	 *
	 * @param almanac ALMANAC to set
	 */
	public void setAlmanac(final ALMANACObject almanac) {
		this.almanac = almanac;
	}
	
	/**
	 * Optional EPHEM1 object
	 *
	 * @return EPHEM1
	 */
	public EPHEM1Object getEphem1() {
		return this.ephem1;
	}
	
	/**
	 * Optional EPHEM1 object
	 *
	 * @param ephem1 EPHEM1 to set
	 */
	public void setEphem1(final EPHEM1Object ephem1) {
		this.ephem1 = ephem1;
	}
	
	/**
	 * Optional EPHEM2 object
	 *
	 * @return EPHEM2
	 */
	public EPHEM2Object getEphem2() {
		return this.ephem2;
	}
	
	/**
	 * Optional EPHEM2 object
	 *
	 * @param ephem2 EPHEM2 to set
	 */
	public void setEphem2(final EPHEM2Object ephem2) {
		this.ephem2 = ephem2;
	}
	
	/**
	 * Optional EPHEM3 object
	 *
	 * @return EPHEM3
	 */
	public EPHEM3Object getEphem3() {
		return this.ephem3;
	}
	
	/**
	 * Optional EPHEM3 object
	 *
	 * @param ephem3 EPHEM3 to set
	 */
	public void setEphem3(final EPHEM3Object ephem3) {
		this.ephem3 = ephem3;
	}
	
	/**
	 * Optional ERD object
	 *
	 * @return ERD
	 */
	public ERDObject getErd() {
		return this.erd;
	}
	
	/**
	 * Optional ERD object
	 *
	 * @param erd ERD to set
	 */
	public void setErd(final ERDObject erd) {
		this.erd = erd;
	}
	
	/**
	 * Optional HEALTH object
	 *
	 * @return HEALTH
	 */
	public HEALTHObject getHealth() {
		return this.health;
	}
	
	/**
	 * Optional HEALTH object
	 *
	 * @param health HEALTH to set
	 */
	public void setHealth(final HEALTHObject health) {
		this.health = health;
	}
	
	/**
	 * Optional HEALTH2 object
	 *
	 * @return HEALTH2
	 */
	public HEALTH2Object getHealth2() {
		return this.health2;
	}
	
	/**
	 * Optional HEALTH2 object
	 *
	 * @param health2 HEALTH2 to set
	 */
	public void setHealth2(final HEALTH2Object health2) {
		this.health2 = health2;
	}
	
	/**
	 * Optional IONO object
	 *
	 * @return IONO
	 */
	public IONOObject getIono() {
		return this.iono;
	}
	
	/**
	 * Optional IONO object
	 *
	 * @param iono IONO to set
	 */
	public void setIono(final IONOObject iono) {
		this.iono = iono;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SUBFRAMEObject)) {
			return false;
		}
		
		final SUBFRAMEObject that = (SUBFRAMEObject) o;
		
		if (this.MSBs != that.MSBs) {
			return false;
		}
		if (this.pageid != that.pageid) {
			return false;
		}
		if (this.satelliteNumber != that.satelliteNumber) {
			return false;
		}
		if (this.scaled != that.scaled) {
			return false;
		}
		if (this.subframeNumber != that.subframeNumber) {
			return false;
		}
		if (this.almanac != null ? !this.almanac.equals(that.almanac) : that.almanac != null) {
			return false;
		}
		if (this.device != null ? !this.device.equals(that.device) : that.device != null) {
			return false;
		}
		if (this.ephem1 != null ? !this.ephem1.equals(that.ephem1) : that.ephem1 != null) {
			return false;
		}
		if (this.ephem2 != null ? !this.ephem2.equals(that.ephem2) : that.ephem2 != null) {
			return false;
		}
		if (this.ephem3 != null ? !this.ephem3.equals(that.ephem3) : that.ephem3 != null) {
			return false;
		}
		if (this.erd != null ? !this.erd.equals(that.erd) : that.erd != null) {
			return false;
		}
		if (this.health != null ? !this.health.equals(that.health) : that.health != null) {
			return false;
		}
		if (this.health2 != null ? !this.health2.equals(that.health2) : that.health2 != null) {
			return false;
		}
		if (this.iono != null ? !this.iono.equals(that.iono) : that.iono != null) {
			return false;
		}
		if (this.systemMessage != null ? !this.systemMessage.equals(that.systemMessage) : that.systemMessage != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.device != null ? this.device.hashCode() : 0;
		result = (31 * result) + this.subframeNumber;
		result = (31 * result) + this.satelliteNumber;
		result = (31 * result) + this.MSBs;
		result = (31 * result) + (this.scaled ? 1 : 0);
		result = (31 * result) + this.pageid;
		result = (31 * result) + (this.systemMessage != null ? this.systemMessage.hashCode() : 0);
		result = (31 * result) + (this.almanac != null ? this.almanac.hashCode() : 0);
		result = (31 * result) + (this.ephem1 != null ? this.ephem1.hashCode() : 0);
		result = (31 * result) + (this.ephem2 != null ? this.ephem2.hashCode() : 0);
		result = (31 * result) + (this.ephem3 != null ? this.ephem3.hashCode() : 0);
		result = (31 * result) + (this.erd != null ? this.erd.hashCode() : 0);
		result = (31 * result) + (this.health != null ? this.health.hashCode() : 0);
		result = (31 * result) + (this.health2 != null ? this.health2.hashCode() : 0);
		result = (31 * result) + (this.iono != null ? this.iono.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("SUBFRAMEObject{device=");
		sb.append(this.device);
		sb.append(", subframeNumber=");
		sb.append(this.subframeNumber);
		sb.append(", satelliteNumber=");
		sb.append(this.satelliteNumber);
		sb.append(", TOW17=");
		sb.append(this.MSBs);
		sb.append(", scaled=");
		sb.append(this.scaled);
		sb.append(", pageid=");
		sb.append(this.pageid);
		if (this.almanac != null) {
			sb.append(", almanac={");
			sb.append(this.almanac.toString());
			sb.append("}");
		} else if (this.ephem1 != null) {
			sb.append(", ephem1={");
			sb.append(this.ephem1.toString());
			sb.append("}");
		} else if (this.ephem2 != null) {
			sb.append(", ephem2={");
			sb.append(this.ephem2.toString());
			sb.append("}");
		} else if (this.ephem3 != null) {
			sb.append(", ephem3={");
			sb.append(this.ephem3.toString());
			sb.append("}");
		} else if (this.erd != null) {
			sb.append(", erd={");
			sb.append(this.erd.toString());
			sb.append("}");
		} else if (this.health != null) {
			sb.append(", health={");
			sb.append(this.health.toString());
			sb.append("}");
		} else if (this.health2 != null) {
			sb.append(", health2={");
			sb.append(this.health2.toString());
			sb.append("}");
		} else if (this.systemMessage != null) {
			sb.append(", systemMessage=");
			sb.append(this.systemMessage);
		} else if (this.iono != null) {
			sb.append(", iono={");
			sb.append(this.iono.toString());
			sb.append("}");
		}
		sb.append("}");
		return sb.toString();
	}
	
}
