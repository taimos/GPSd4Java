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
public class ALMANACObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "ALMANAC";
	
	private int ID = -1;
	
	private int Health = -1;
	
	private double e = Double.NaN;
	
	private int toa = -1;
	
	private double deltai = Double.NaN;
	
	private double Omegad = Double.NaN;
	
	private double sqrtA = Double.NaN;
	
	private double Omega0 = Double.NaN;
	
	private double omega = Double.NaN;
	
	private double M0 = Double.NaN;
	
	private double af0 = Double.NaN;
	
	private double af1 = Double.NaN;
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(final int iD) {
		this.ID = iD;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return this.Health;
	}
	
	/**
	 * @param health the health to set
	 */
	public void setHealth(final int health) {
		this.Health = health;
	}
	
	/**
	 * @return the e
	 */
	public double getE() {
		return this.e;
	}
	
	/**
	 * @param e the e to set
	 */
	public void setE(final double e) {
		this.e = e;
	}
	
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
	 * @return the deltai
	 */
	public double getDeltai() {
		return this.deltai;
	}
	
	/**
	 * @param deltai the deltai to set
	 */
	public void setDeltai(final double deltai) {
		this.deltai = deltai;
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
	
	/**
	 * @return the sqrtA
	 */
	public double getSqrtA() {
		return this.sqrtA;
	}
	
	/**
	 * @param sqrtA the sqrtA to set
	 */
	public void setSqrtA(final double sqrtA) {
		this.sqrtA = sqrtA;
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
	 * @return the m0
	 */
	public double getM0() {
		return this.M0;
	}
	
	/**
	 * @param m0 the m0 to set
	 */
	public void setM0(final double m0) {
		this.M0 = m0;
	}
	
	/**
	 * @return the af0
	 */
	public double getAf0() {
		return this.af0;
	}
	
	/**
	 * @param af0 the af0 to set
	 */
	public void setAf0(final double af0) {
		this.af0 = af0;
	}
	
	/**
	 * @return the af1
	 */
	public double getAf1() {
		return this.af1;
	}
	
	/**
	 * @param af1 the af1 to set
	 */
	public void setAf1(final double af1) {
		this.af1 = af1;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ALMANACObject)) {
			return false;
		}
		
		final ALMANACObject that = (ALMANACObject) o;
		
		if (this.Health != that.Health) {
			return false;
		}
		if (this.ID != that.ID) {
			return false;
		}
		if (Double.compare(that.M0, this.M0) != 0) {
			return false;
		}
		if (Double.compare(that.Omega0, this.Omega0) != 0) {
			return false;
		}
		if (Double.compare(that.Omegad, this.Omegad) != 0) {
			return false;
		}
		if (Double.compare(that.af0, this.af0) != 0) {
			return false;
		}
		if (Double.compare(that.af1, this.af1) != 0) {
			return false;
		}
		if (Double.compare(that.deltai, this.deltai) != 0) {
			return false;
		}
		if (Double.compare(that.e, this.e) != 0) {
			return false;
		}
		if (Double.compare(that.omega, this.omega) != 0) {
			return false;
		}
		if (Double.compare(that.sqrtA, this.sqrtA) != 0) {
			return false;
		}
		if (this.toa != that.toa) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = this.ID;
		result = (31 * result) + this.Health;
		temp = this.e != +0.0d ? Double.doubleToLongBits(this.e) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		result = (31 * result) + this.toa;
		temp = this.deltai != +0.0d ? Double.doubleToLongBits(this.deltai) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Omegad != +0.0d ? Double.doubleToLongBits(this.Omegad) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.sqrtA != +0.0d ? Double.doubleToLongBits(this.sqrtA) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Omega0 != +0.0d ? Double.doubleToLongBits(this.Omega0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.omega != +0.0d ? Double.doubleToLongBits(this.omega) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.M0 != +0.0d ? Double.doubleToLongBits(this.M0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.af0 != +0.0d ? Double.doubleToLongBits(this.af0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.af1 != +0.0d ? Double.doubleToLongBits(this.af1) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ALMANACObject{ID=");
		sb.append(this.ID);
		sb.append(", Health=");
		sb.append(this.Health);
		sb.append(", e=");
		sb.append(this.e);
		sb.append(", toa=");
		sb.append(this.toa);
		sb.append(", deltai=");
		sb.append(this.deltai);
		sb.append(", Omegad=");
		sb.append(this.Omegad);
		sb.append(", sqrtA=");
		sb.append(this.sqrtA);
		sb.append(", Omega0=");
		sb.append(this.Omega0);
		sb.append(", omega=");
		sb.append(this.omega);
		sb.append(", M0=");
		sb.append(this.M0);
		sb.append(", af0=");
		sb.append(this.af0);
		sb.append(", af1=");
		sb.append(this.af1);
		sb.append("}");
		return sb.toString();
	}
}
