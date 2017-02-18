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
public class HEALTH2Object implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "HEALTH2";
	
	private final int[] SV = new int[24];
	
	private int toa = -1;
	
	private int WNa = -1;
	
	/**
	 * @return the toa
	 */
	public int getToa() {
		return this.toa;
	}
	
	/**
	 * @param toa the toa to set
	 */
	public void setToa(final int toa) {
		this.toa = toa;
	}
	
	/**
	 * @return the wNa
	 */
	public int getWNa() {
		return this.WNa;
	}
	
	/**
	 * @param wNa the wNa to set
	 */
	public void setWNa(final int wNa) {
		this.WNa = wNa;
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
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof HEALTH2Object)) {
			return false;
		}
		
		final HEALTH2Object that = (HEALTH2Object) o;
		
		if (this.WNa != that.WNa) {
			return false;
		}
		if (this.toa != that.toa) {
			return false;
		}
		if (!Arrays.equals(this.SV, that.SV)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.SV != null ? Arrays.hashCode(this.SV) : 0;
		result = (31 * result) + this.toa;
		result = (31 * result) + this.WNa;
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("HEALTH2Object{toa=");
		sb.append(this.toa);
		sb.append(", WNa=");
		sb.append(this.WNa);
		for (int index = 1; index <= 24; index++) {
			sb.append(", SV");
			sb.append(index);
			sb.append("=");
			sb.append(this.SV[index - 1]);
		}
		sb.append("}");
		return sb.toString();
	}
	
}
