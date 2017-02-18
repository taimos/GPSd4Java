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
public class EPHEM3Object implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "EPHEM3";
	
	private int IODE = -1;
	
	private double IDOT = Double.NaN;
	
	private double Cic = Double.NaN;
	
	private double Omega0 = Double.NaN;
	
	private double Cis = Double.NaN;
	
	private double i0 = Double.NaN;
	
	private double Crc = Double.NaN;
	
	private double omega = Double.NaN;
	
	private double Omegad = Double.NaN;
	
	/**
	 * @return the iODE
	 */
	public int getIODE() {
		return this.IODE;
	}
	
	/**
	 * @param iODE the iODE to set
	 */
	public void setIODE(final int iODE) {
		this.IODE = iODE;
	}
	
	/**
	 * @return the iDOT
	 */
	public double getIDOT() {
		return this.IDOT;
	}
	
	/**
	 * @param iDOT the iDOT to set
	 */
	public void setIDOT(final double iDOT) {
		this.IDOT = iDOT;
	}
	
	/**
	 * @return the cic
	 */
	public double getCic() {
		return this.Cic;
	}
	
	/**
	 * @param cic the cic to set
	 */
	public void setCic(final double cic) {
		this.Cic = cic;
	}
	
	/**
	 * @return the omega0
	 */
	public double getOmega0() {
		return this.Omega0;
	}
	
	/**
	 * @param omega0 the omega0 to set
	 */
	public void setOmega0(final double omega0) {
		this.Omega0 = omega0;
	}
	
	/**
	 * @return the cis
	 */
	public double getCis() {
		return this.Cis;
	}
	
	/**
	 * @param cis the cis to set
	 */
	public void setCis(final double cis) {
		this.Cis = cis;
	}
	
	/**
	 * @return the i0
	 */
	public double getI0() {
		return this.i0;
	}
	
	/**
	 * @param i0 the i0 to set
	 */
	public void setI0(final double i0) {
		this.i0 = i0;
	}
	
	/**
	 * @return the crc
	 */
	public double getCrc() {
		return this.Crc;
	}
	
	/**
	 * @param crc the crc to set
	 */
	public void setCrc(final double crc) {
		this.Crc = crc;
	}
	
	/**
	 * @return the omega
	 */
	public double getOmega() {
		return this.omega;
	}
	
	/**
	 * @param omega the omega to set
	 */
	public void setOmega(final double omega) {
		this.omega = omega;
	}
	
	/**
	 * @return the omegad
	 */
	public double getOmegad() {
		return this.Omegad;
	}
	
	/**
	 * @param omegad the omegad to set
	 */
	public void setOmegad(final double omegad) {
		this.Omegad = omegad;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof EPHEM3Object)) {
			return false;
		}
		
		final EPHEM3Object that = (EPHEM3Object) o;
		
		if (Double.compare(that.Cic, this.Cic) != 0) {
			return false;
		}
		if (Double.compare(that.Cis, this.Cis) != 0) {
			return false;
		}
		if (Double.compare(that.Crc, this.Crc) != 0) {
			return false;
		}
		if (Double.compare(that.IDOT, this.IDOT) != 0) {
			return false;
		}
		if (this.IODE != that.IODE) {
			return false;
		}
		if (Double.compare(that.Omega0, this.Omega0) != 0) {
			return false;
		}
		if (Double.compare(that.Omegad, this.Omegad) != 0) {
			return false;
		}
		if (Double.compare(that.i0, this.i0) != 0) {
			return false;
		}
		if (Double.compare(that.omega, this.omega) != 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = this.IODE;
		temp = this.IDOT != +0.0d ? Double.doubleToLongBits(this.IDOT) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Cic != +0.0d ? Double.doubleToLongBits(this.Cic) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Omega0 != +0.0d ? Double.doubleToLongBits(this.Omega0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Cis != +0.0d ? Double.doubleToLongBits(this.Cis) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.i0 != +0.0d ? Double.doubleToLongBits(this.i0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Crc != +0.0d ? Double.doubleToLongBits(this.Crc) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.omega != +0.0d ? Double.doubleToLongBits(this.omega) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Omegad != +0.0d ? Double.doubleToLongBits(this.Omegad) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("EPHEM3Object{IODE=");
		sb.append(this.IODE);
		sb.append(", IDOT=");
		sb.append(this.IDOT);
		sb.append(", Cic=");
		sb.append(this.Cic);
		sb.append(", Omega0=");
		sb.append(this.Omega0);
		sb.append(", Cis=");
		sb.append(this.Cis);
		sb.append(", i0=");
		sb.append(this.i0);
		sb.append(", Crc=");
		sb.append(this.Crc);
		sb.append(", omega=");
		sb.append(this.omega);
		sb.append(", Omegad=");
		sb.append(this.Omegad);
		sb.append("}");
		return sb.toString();
	}
	
}
