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
public class IONOObject implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "IONO";
	
	private double alpha0 = Double.NaN;
	
	private double alpha1 = Double.NaN;
	
	private double alpha2 = Double.NaN;
	
	private double alpha3 = Double.NaN;
	
	private double beta0 = Double.NaN;
	
	private double beta1 = Double.NaN;
	
	private double beta2 = Double.NaN;
	
	private double beta3 = Double.NaN;
	
	private double A0 = Double.NaN;
	
	private double A1 = Double.NaN;
	
	private double tot = Double.NaN;
	
	private int WNt = -1;
	
	private int leap = -1;
	
	private int WNlsf = -1;
	
	private int DN = -1;
	
	private int lsf = -1;
	
	/**
	 * @return the alpha0
	 */
	public double getAlpha0() {
		return this.alpha0;
	}
	
	/**
	 * @param alpha0 the alpha0 to set
	 */
	public void setAlpha0(final double alpha0) {
		this.alpha0 = alpha0;
	}
	
	/**
	 * @return the alpha1
	 */
	public double getAlpha1() {
		return this.alpha1;
	}
	
	/**
	 * @param alpha1 the alpha1 to set
	 */
	public void setAlpha1(final double alpha1) {
		this.alpha1 = alpha1;
	}
	
	/**
	 * @return the alpha2
	 */
	public double getAlpha2() {
		return this.alpha2;
	}
	
	/**
	 * @param alpha2 the alpha2 to set
	 */
	public void setAlpha2(final double alpha2) {
		this.alpha2 = alpha2;
	}
	
	/**
	 * @return the alpha3
	 */
	public double getAlpha3() {
		return this.alpha3;
	}
	
	/**
	 * @param alpha3 the alpha3 to set
	 */
	public void setAlpha3(final double alpha3) {
		this.alpha3 = alpha3;
	}
	
	/**
	 * @return the beta0
	 */
	public double getBeta0() {
		return this.beta0;
	}
	
	/**
	 * @param beta0 the beta0 to set
	 */
	public void setBeta0(final double beta0) {
		this.beta0 = beta0;
	}
	
	/**
	 * @return the beta1
	 */
	public double getBeta1() {
		return this.beta1;
	}
	
	/**
	 * @param beta1 the beta1 to set
	 */
	public void setBeta1(final double beta1) {
		this.beta1 = beta1;
	}
	
	/**
	 * @return the beta2
	 */
	public double getBeta2() {
		return this.beta2;
	}
	
	/**
	 * @param beta2 the beta2 to set
	 */
	public void setBeta2(final double beta2) {
		this.beta2 = beta2;
	}
	
	/**
	 * @return the beta3
	 */
	public double getBeta3() {
		return this.beta3;
	}
	
	/**
	 * @param beta3 the beta3 to set
	 */
	public void setBeta3(final double beta3) {
		this.beta3 = beta3;
	}
	
	/**
	 * @return the a0
	 */
	public double getA0() {
		return this.A0;
	}
	
	/**
	 * @param a0 the a0 to set
	 */
	public void setA0(final double a0) {
		this.A0 = a0;
	}
	
	/**
	 * @return the a1
	 */
	public double getA1() {
		return this.A1;
	}
	
	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(final double a1) {
		this.A1 = a1;
	}
	
	/**
	 * @return the tot
	 */
	public double getTot() {
		return this.tot;
	}
	
	/**
	 * @param tot the tot to set
	 */
	public void setTot(final double tot) {
		this.tot = tot;
	}
	
	/**
	 * @return the wNt
	 */
	public int getWNt() {
		return this.WNt;
	}
	
	/**
	 * @param wNt the wNt to set
	 */
	public void setWNt(final int wNt) {
		this.WNt = wNt;
	}
	
	/**
	 * @return the leap
	 */
	public int getLeap() {
		return this.leap;
	}
	
	/**
	 * @param leap the leap to set
	 */
	public void setLeap(final int leap) {
		this.leap = leap;
	}
	
	/**
	 * @return the wNlsf
	 */
	public int getWNlsf() {
		return this.WNlsf;
	}
	
	/**
	 * @param wNlsf the wNlsf to set
	 */
	public void setWNlsf(final int wNlsf) {
		this.WNlsf = wNlsf;
	}
	
	/**
	 * @return the dN
	 */
	public int getDN() {
		return this.DN;
	}
	
	/**
	 * @param dN the dN to set
	 */
	public void setDN(final int dN) {
		this.DN = dN;
	}
	
	/**
	 * @return the lsf
	 */
	public int getLsf() {
		return this.lsf;
	}
	
	/**
	 * @param lsf the lsf to set
	 */
	public void setLsf(final int lsf) {
		this.lsf = lsf;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IONOObject)) {
			return false;
		}
		
		final IONOObject that = (IONOObject) o;
		
		if (Double.compare(that.A0, this.A0) != 0) {
			return false;
		}
		if (Double.compare(that.A1, this.A1) != 0) {
			return false;
		}
		if (this.DN != that.DN) {
			return false;
		}
		if (this.WNlsf != that.WNlsf) {
			return false;
		}
		if (this.WNt != that.WNt) {
			return false;
		}
		if (Double.compare(that.alpha0, this.alpha0) != 0) {
			return false;
		}
		if (Double.compare(that.alpha1, this.alpha1) != 0) {
			return false;
		}
		if (Double.compare(that.alpha2, this.alpha2) != 0) {
			return false;
		}
		if (Double.compare(that.alpha3, this.alpha3) != 0) {
			return false;
		}
		if (Double.compare(that.beta0, this.beta0) != 0) {
			return false;
		}
		if (Double.compare(that.beta1, this.beta1) != 0) {
			return false;
		}
		if (Double.compare(that.beta2, this.beta2) != 0) {
			return false;
		}
		if (Double.compare(that.beta3, this.beta3) != 0) {
			return false;
		}
		if (this.leap != that.leap) {
			return false;
		}
		if (this.lsf != that.lsf) {
			return false;
		}
		if (Double.compare(that.tot, this.tot) != 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = this.alpha0 != +0.0d ? Double.doubleToLongBits(this.alpha0) : 0L;
		result = (int) (temp ^ (temp >>> 32));
		temp = this.alpha1 != +0.0d ? Double.doubleToLongBits(this.alpha1) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.alpha2 != +0.0d ? Double.doubleToLongBits(this.alpha2) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.alpha3 != +0.0d ? Double.doubleToLongBits(this.alpha3) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.beta0 != +0.0d ? Double.doubleToLongBits(this.beta0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.beta1 != +0.0d ? Double.doubleToLongBits(this.beta1) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.beta2 != +0.0d ? Double.doubleToLongBits(this.beta2) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.beta3 != +0.0d ? Double.doubleToLongBits(this.beta3) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.A0 != +0.0d ? Double.doubleToLongBits(this.A0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.A1 != +0.0d ? Double.doubleToLongBits(this.A1) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.tot != +0.0d ? Double.doubleToLongBits(this.tot) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		result = (31 * result) + this.WNt;
		result = (31 * result) + this.leap;
		result = (31 * result) + this.WNlsf;
		result = (31 * result) + this.DN;
		result = (31 * result) + this.lsf;
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("IONOObject{alpha0=");
		sb.append(this.alpha0);
		sb.append(", alpha1=");
		sb.append(this.alpha1);
		sb.append(", alpha2=");
		sb.append(this.alpha2);
		sb.append(", alpha3=");
		sb.append(this.alpha3);
		sb.append(", beta0=");
		sb.append(this.beta0);
		sb.append(", beta1=");
		sb.append(this.beta1);
		sb.append(", beta2=");
		sb.append(this.beta2);
		sb.append(", beta3=");
		sb.append(this.beta3);
		sb.append(", A0=");
		sb.append(this.A0);
		sb.append(", A1=");
		sb.append(this.A1);
		sb.append(", tot=");
		sb.append(this.tot);
		sb.append(", WNt=");
		sb.append(this.WNt);
		sb.append(", leap=");
		sb.append(this.leap);
		sb.append(", WNlsf=");
		sb.append(this.WNlsf);
		sb.append(", DN=");
		sb.append(this.DN);
		sb.append(", lsf=");
		sb.append(this.lsf);
		sb.append("}");
		return sb.toString();
	}
	
}
