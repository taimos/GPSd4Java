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

import java.util.Arrays;

import de.taimos.gpsd4java.types.IGPSObject;

/**
 * @author aevdokimov
 */
public class HEALTHObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "HEALTH";
	
	private final int[] SV = new int[32];
	
	private final int[] SVH = new int[8];
	
	private int data_id = -1;
	
	/**
	 * @return the data_id
	 */
	public int getData_id() {
		return this.data_id;
	}
	
	/**
	 * @param data_id the data_id to set
	 */
	public void setData_id(final int data_id) {
		this.data_id = data_id;
	}
	
	/**
	 * @param index the index
	 * @return the SV
	 */
	public int getSVbyIndex(final int index) {
		return this.SV[index];
	}
	
	/**
	 * @param index   the index
	 * @param SVvalue the SV
	 */
	public void setSVbyIndex(final int index, final int SVvalue) {
		this.SV[index] = SVvalue;
	}
	
	/**
	 * @param index the index
	 * @return the SVH
	 */
	public int getSVHbyIndex(final int index) {
		return this.SVH[index];
	}
	
	/**
	 * @param index    the index
	 * @param SVHvalue the SVH
	 */
	public void setSVHbyIndex(final int index, final int SVHvalue) {
		this.SVH[index] = SVHvalue;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof HEALTHObject)) {
			return false;
		}
		
		final HEALTHObject that = (HEALTHObject) o;
		
		if (this.data_id != that.data_id) {
			return false;
		}
		if (!Arrays.equals(this.SV, that.SV)) {
			return false;
		}
		if (!Arrays.equals(this.SVH, that.SVH)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.SV != null ? Arrays.hashCode(this.SV) : 0;
		result = (31 * result) + (this.SVH != null ? Arrays.hashCode(this.SVH) : 0);
		result = (31 * result) + this.data_id;
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("HEALTHObject{data_id=");
		sb.append(this.data_id);
		for (int index = 1; index <= 32; index++) {
			sb.append(", SV");
			sb.append(index);
			sb.append("=");
			sb.append(this.SV[index - 1]);
		}
		for (int index = 0; index <= 7; index++) {
			sb.append(", SVH");
			sb.append(index + 25);
			sb.append("=");
			sb.append(this.SVH[index]);
		}
		sb.append("}");
		return sb.toString();
	}
	
}
