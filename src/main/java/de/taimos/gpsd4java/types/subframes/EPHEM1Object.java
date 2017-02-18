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
public class EPHEM1Object implements IGPSObject {
	
	/**
	 * the GPSd internal name
	 */
	public static final String NAME = "EPHEM1";
	
	private int WN = -1;
	
	private int IODC = -1;
	
	private int L2 = -1;
	
	private double ura = Double.NaN;
	
	private double hlth = Double.NaN;
	
	private int L2P = -1;
	
	private double Tgd = Double.NaN;
	
	private int toc = -1;
	
	private double af2 = Double.NaN;
	
	private double af1 = Double.NaN;
	
	private double af0 = Double.NaN;
	
	/**
	 * @return the wN
	 */
	public int getWN() {
		return this.WN;
	}
	
	/**
	 * @param wN the wN to set
	 */
	public void setWN(final int wN) {
		this.WN = wN;
	}
	
	/**
	 * @return the iODC
	 */
	public int getIODC() {
		return this.IODC;
	}
	
	/**
	 * @param iODC the iODC to set
	 */
	public void setIODC(final int iODC) {
		this.IODC = iODC;
	}
	
	/**
	 * @return the l2
	 */
	public int getL2() {
		return this.L2;
	}
	
	/**
	 * @param l2 the l2 to set
	 */
	public void setL2(final int l2) {
		this.L2 = l2;
	}
	
	/**
	 * @return the ura
	 */
	public double getUra() {
		return this.ura;
	}
	
	/**
	 * @param ura the ura to set
	 */
	public void setUra(final double ura) {
		this.ura = ura;
	}
	
	/**
	 * @return the hlth
	 */
	public double getHlth() {
		return this.hlth;
	}
	
	/**
	 * @param hlth the hlth to set
	 */
	public void setHlth(final double hlth) {
		this.hlth = hlth;
	}
	
	/**
	 * @return the l2P
	 */
	public int getL2P() {
		return this.L2P;
	}
	
	/**
	 * @param l2p the l2P to set
	 */
	public void setL2P(final int l2p) {
		this.L2P = l2p;
	}
	
	/**
	 * @return the tgd
	 */
	public double getTgd() {
		return this.Tgd;
	}
	
	/**
	 * @param tgd the tgd to set
	 */
	public void setTgd(final double tgd) {
		this.Tgd = tgd;
	}
	
	/**
	 * @return the toc
	 */
	public int getToc() {
		return this.toc;
	}
	
	/**
	 * @param toc the toc to set
	 */
	public void setToc(final int toc) {
		this.toc = toc;
	}
	
	/**
	 * @return the af2
	 */
	public double getAf2() {
		return this.af2;
	}
	
	/**
	 * @param af2 the af2 to set
	 */
	public void setAf2(final double af2) {
		this.af2 = af2;
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
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		
		final EPHEM1Object that = (EPHEM1Object) o;
		
		if (this.IODC != that.IODC) {
			return false;
		}
		if (this.L2 != that.L2) {
			return false;
		}
		if (this.L2P != that.L2P) {
			return false;
		}
		if (Double.compare(that.Tgd, this.Tgd) != 0) {
			return false;
		}
		if (this.WN != that.WN) {
			return false;
		}
		if (Double.compare(that.af0, this.af0) != 0) {
			return false;
		}
		if (Double.compare(that.af1, this.af1) != 0) {
			return false;
		}
		if (Double.compare(that.af2, this.af2) != 0) {
			return false;
		}
		if (Double.compare(that.hlth, this.hlth) != 0) {
			return false;
		}
		if (this.toc != that.toc) {
			return false;
		}
		if (Double.compare(that.ura, this.ura) != 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = this.WN;
		result = (31 * result) + this.IODC;
		result = (31 * result) + this.L2;
		temp = this.ura != +0.0d ? Double.doubleToLongBits(this.ura) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.hlth != +0.0d ? Double.doubleToLongBits(this.hlth) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		result = (31 * result) + this.L2P;
		temp = this.Tgd != +0.0d ? Double.doubleToLongBits(this.Tgd) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		result = (31 * result) + this.toc;
		temp = this.af2 != +0.0d ? Double.doubleToLongBits(this.af2) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.af1 != +0.0d ? Double.doubleToLongBits(this.af1) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		temp = this.af0 != +0.0d ? Double.doubleToLongBits(this.af0) : 0L;
		result = (31 * result) + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("EPHEM1Object{WN=");
		sb.append(this.WN);
		sb.append(", IODC=");
		sb.append(this.IODC);
		sb.append(", ura=");
		sb.append(this.ura);
		sb.append(", L2=");
		sb.append(this.L2);
		sb.append(", hlth=");
		sb.append(this.hlth);
		sb.append(", L2P=");
		sb.append(this.L2P);
		sb.append(", Tgd=");
		sb.append(this.Tgd);
		sb.append(", toc=");
		sb.append(this.toc);
		sb.append(", af2=");
		sb.append(this.af2);
		sb.append(", af0=");
		sb.append(this.af0);
		sb.append(", af1=");
		sb.append(this.af1);
		sb.append("}");
		return sb.toString();
	}
	
}
