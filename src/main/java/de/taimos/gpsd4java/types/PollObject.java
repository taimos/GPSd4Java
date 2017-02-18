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
 */
public class PollObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "POLL";
	
	private double timestamp;
	
	private int active;
	
	private List<TPVObject> fixes;
	
	private List<SKYObject> skyviews;
	
	private List<GSTObject> gst;
	
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
	 * Count of active devices.
	 *
	 * @return the active
	 */
	public int getActive() {
		return this.active;
	}
	
	/**
	 * Count of active devices.
	 *
	 * @param active the active to set
	 */
	public void setActive(final int active) {
		this.active = active;
	}
	
	/**
	 * list of TPV objects
	 *
	 * @return the fixes
	 */
	public List<TPVObject> getFixes() {
		return this.fixes;
	}
	
	/**
	 * list of TPV objects
	 *
	 * @param fixes the fixes to set
	 */
	public void setFixes(final List<TPVObject> fixes) {
		this.fixes = fixes;
	}
	
	/**
	 * list of SKY objects
	 *
	 * @return the skyviews
	 */
	public List<SKYObject> getSkyviews() {
		return this.skyviews;
	}
	
	/**
	 * list of SKY objects
	 *
	 * @param skyviews the skyviews to set
	 */
	public void setSkyviews(final List<SKYObject> skyviews) {
		this.skyviews = skyviews;
	}
	
	/**
	 * @return the gst
	 */
	public List<GSTObject> getGst() {
		return this.gst;
	}
	
	/**
	 * @param gst the gst to set
	 */
	public void setGst(final List<GSTObject> gst) {
		this.gst = gst;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.active;
		result = (prime * result) + ((this.fixes == null) ? 0 : this.fixes.hashCode());
		result = (prime * result) + ((this.skyviews == null) ? 0 : this.skyviews.hashCode());
		result = (prime * result) + ((this.gst == null) ? 0 : this.gst.hashCode());
		long temp;
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
		final PollObject other = (PollObject) obj;
		if (this.active != other.active) {
			return false;
		}
		if (this.fixes == null) {
			if (other.fixes != null) {
				return false;
			}
		} else if (!this.fixes.equals(other.fixes)) {
			return false;
		}
		if (this.skyviews == null) {
			if (other.skyviews != null) {
				return false;
			}
		} else if (!this.skyviews.equals(other.skyviews)) {
			return false;
		}
		if (this.gst == null) {
			if (other.gst != null) {
				return false;
			}
		} else if (!this.gst.equals(other.gst)) {
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
		
		sb.append("PollObject{timestamp=");
		sb.append(this.timestamp);
		sb.append(", active=");
		sb.append(this.active);
		sb.append(", fixes=");
		sb.append(this.fixes.size());
		sb.append(", skyviews=");
		sb.append(this.skyviews.size());
		sb.append(", gst=");
		sb.append(this.gst.size());
		sb.append("}");
		
		return sb.toString();
	}
}
