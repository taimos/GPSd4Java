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
public class WatchObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "WATCH";
	
	private boolean enable = true;
	
	private boolean dump = false;
	
	/**
	 * Enable (true) or disable (false) watcher mode. Default is true.
	 *
	 * @return the enable
	 */
	public boolean isEnable() {
		return this.enable;
	}
	
	/**
	 * Enable (true) or disable (false) watcher mode. Default is true.
	 *
	 * @param enable the enable to set
	 */
	public void setEnable(final boolean enable) {
		this.enable = enable;
	}
	
	/**
	 * Enable (true) or disable (false) dumping of JSON reports. Default is false.
	 *
	 * @return the json
	 */
	public boolean isDump() {
		return this.dump;
	}
	
	/**
	 * Enable (true) or disable (false) dumping of JSON reports. Default is false.
	 *
	 * @param dump the dump to set
	 */
	public void setDump(final boolean dump) {
		this.dump = dump;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (this.dump ? 1231 : 1237);
		result = (prime * result) + (this.enable ? 1231 : 1237);
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
		final WatchObject other = (WatchObject) obj;
		if (this.dump != other.dump) {
			return false;
		}
		if (this.enable != other.enable) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "WatchObject{enable=" + this.enable + ", dump=" + this.dump + "}";
	}
	
}
