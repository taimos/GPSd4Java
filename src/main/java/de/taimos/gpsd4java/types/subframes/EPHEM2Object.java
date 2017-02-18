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
public class EPHEM2Object implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "EPHEM2";
	
	private int IODE = -1;
	
	private double Crs = Double.NaN;
	
	private double deltan = Double.NaN;
	
	private double M0 = Double.NaN;
	
	private double Cuc = Double.NaN;
	
	private double e = Double.NaN;
	
	private double Cus = Double.NaN;
	
	private double sqrtA = Double.NaN;
	
	private int toe = -1;
	
	private int FIT = -1;
	
	private int AODO = -1;
	
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
	 * @return the crs
	 */
	public double getCrs() {
		return this.Crs;
	}
	
	/**
	 * @param crs the crs to set
	 */
	public void setCrs(final double crs) {
		this.Crs = crs;
	}
	
	/**
	 * @return the deltan
	 */
	public double getDeltan() {
		return this.deltan;
	}
	
	/**
	 * @param deltan the deltan to set
	 */
	public void setDeltan(final double deltan) {
		this.deltan = deltan;
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
	 * @return the cuc
	 */
	public double getCuc() {
		return this.Cuc;
	}
	
	/**
	 * @param cuc the cuc to set
	 */
	public void setCuc(final double cuc) {
		this.Cuc = cuc;
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
	 * @return the cus
	 */
	public double getCus() {
		return this.Cus;
	}
	
	/**
	 * @param cus the cus to set
	 */
	public void setCus(final double cus) {
		this.Cus = cus;
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
	 * @return the toe
	 */
	public int getToe() {
		return this.toe;
	}
	
	/**
	 * @param toe the toe to set
	 */
	public void setToe(final int toe) {
		this.toe = toe;
	}
	
	/**
	 * @return the fIT
	 */
	public int getFIT() {
		return this.FIT;
	}
	
	/**
	 * @param fIT the fIT to set
	 */
	public void setFIT(final int fIT) {
		this.FIT = fIT;
	}
	
	/**
	 * @return the aODO
	 */
	public int getAODO() {
		return this.AODO;
	}
	
	/**
	 * @param aODO the aODO to set
	 */
	public void setAODO(final int aODO) {
		this.AODO = aODO;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		
		final EPHEM2Object that = (EPHEM2Object) o;
		
		if (this.AODO != that.AODO) {
			return false;
		}
		if (Double.compare(that.Crs, this.Crs) != 0) {
			return false;
		}
		if (Double.compare(that.Cuc, this.Cuc) != 0) {
			return false;
		}
		if (Double.compare(that.Cus, this.Cus) != 0) {
			return false;
		}
		if (this.FIT != that.FIT) {
			return false;
		}
		if (this.IODE != that.IODE) {
			return false;
		}
		if (Double.compare(that.M0, this.M0) != 0) {
			return false;
		}
		if (Double.compare(that.deltan, this.deltan) != 0) {
			return false;
		}
		if (Double.compare(that.e, this.e) != 0) {
			return false;
		}
		if (Double.compare(that.sqrtA, this.sqrtA) != 0) {
			return false;
		}
		if (this.toe != that.toe) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = this.IODE;
		temp = this.Crs != +0.0d ? Double.doubleToLongBits(this.Crs) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.deltan != +0.0d ? Double.doubleToLongBits(this.deltan) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.M0 != +0.0d ? Double.doubleToLongBits(this.M0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Cuc != +0.0d ? Double.doubleToLongBits(this.Cuc) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.e != +0.0d ? Double.doubleToLongBits(this.e) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.Cus != +0.0d ? Double.doubleToLongBits(this.Cus) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.sqrtA != +0.0d ? Double.doubleToLongBits(this.sqrtA) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		result = (31 * result) + this.toe;
		result = (31 * result) + this.FIT;
		result = (31 * result) + this.AODO;
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("EPHEM2Object{IODE=");
		sb.append(this.IODE);
		sb.append(", Crs=");
		sb.append(this.Crs);
		sb.append(", deltan=");
		sb.append(this.deltan);
		sb.append(", M0=");
		sb.append(this.M0);
		sb.append(", Cuc=");
		sb.append(this.Cuc);
		sb.append(", e=");
		sb.append(this.e);
		sb.append(", Cus=");
		sb.append(this.Cus);
		sb.append(", sqrtA=");
		sb.append(this.sqrtA);
		sb.append(", toe=");
		sb.append(this.toe);
		sb.append(", FIT=");
		sb.append(this.FIT);
		sb.append(", AODO=");
		sb.append(this.AODO);
		sb.append("}");
		return sb.toString();
	}
	
}
