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
public class ERDObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "ERD";
	
	private int[] ERD = new int[30];
	
	private int ai = -1;
	
	/**
	 * @return the eRD
	 */
	public int[] getERD() {
		return this.ERD;
	}
	
	/**
	 * @param eRD the eRD to set
	 */
	public void setERD(final int[] eRD) {
		this.ERD = eRD;
	}
	
	/**
	 * @return the ai
	 */
	public int getAi() {
		return this.ai;
	}
	
	/**
	 * @param ai the ai to set
	 */
	public void setAi(final int ai) {
		this.ai = ai;
	}
	
	/**
	 * @param index
	 * @return the ERD
	 */
	public int getERDbyIndex(final int index) {
		return this.ERD[index];
	}
	
	/**
	 * @param index    the index
	 * @param ERDvalue the ERD
	 */
	public void setERDbyIndex(final int index, final int ERDvalue) {
		this.ERD[index] = ERDvalue;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ERDObject)) {
			return false;
		}
		
		final ERDObject erdObject = (ERDObject) o;
		
		if (this.ai != erdObject.ai) {
			return false;
		}
		if (!Arrays.equals(this.ERD, erdObject.ERD)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.ERD != null ? Arrays.hashCode(this.ERD) : 0;
		result = (31 * result) + this.ai;
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ERDObject{ai=");
		sb.append(this.ai);
		for (int index = 1; index <= 30; index++) {
			sb.append(", ERD");
			sb.append(index);
			sb.append("=");
			sb.append(this.ERD[index - 1]);
		}
		sb.append("}");
		return sb.toString();
	}
	
}
