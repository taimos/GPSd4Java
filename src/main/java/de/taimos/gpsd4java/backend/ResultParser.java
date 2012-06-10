/**
 * Copyright 2011 Thorsten Höger, Taimos GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.taimos.gpsd4java.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import de.taimos.gpsd4java.types.ATTObject;
import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.ENMEAMode;
import de.taimos.gpsd4java.types.EParity;
import de.taimos.gpsd4java.types.GSTObject;
import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.SATObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.VersionObject;
import de.taimos.gpsd4java.types.WatchObject;
import de.taimos.gpsd4java.types.subframes.ALMANACObject;
import de.taimos.gpsd4java.types.subframes.EPHEM1Object;
import de.taimos.gpsd4java.types.subframes.EPHEM2Object;
import de.taimos.gpsd4java.types.subframes.EPHEM3Object;
import de.taimos.gpsd4java.types.subframes.ERDObject;
import de.taimos.gpsd4java.types.subframes.HEALTH2Object;
import de.taimos.gpsd4java.types.subframes.HEALTHObject;
import de.taimos.gpsd4java.types.subframes.IONOObject;
import de.taimos.gpsd4java.types.subframes.SUBFRAMEObject;

/**
 * This class is used to parse responses from GPSd<br>
 * 
 * @author thoeger
 */
public class ResultParser extends AbstractResultParser {

	private static final Logger log = Logger.getLogger(ResultParser.class.getName());

	private final DateFormat dateFormat; // Don't make this static!

	/**
	 * Create new ResultParser
	 */
	public ResultParser() {
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		this.dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * parse {@link JSONObject} into {@link IGPSObject}
	 * 
	 * @param json
	 *            the {@link JSONObject} to parse
	 * @return the parsed object
	 * @throws ParseException
	 *             if parsing fails
	 */
	@Override
	public IGPSObject parse(final JSONObject json) throws ParseException {
		IGPSObject gps = null;
		final String clazz = json.optString("class");

		if ("TPV".equals(clazz)) {
			final TPVObject tpv = new TPVObject();
			tpv.setTag(json.optString("tag", null));
			tpv.setDevice(json.optString("device", null));
			tpv.setTimestamp(this.parseTimestamp(json, "time"));
			tpv.setTimestampError(json.optDouble("ept", Double.NaN));
			tpv.setLatitude(json.optDouble("lat", Double.NaN));
			tpv.setLongitude(json.optDouble("lon", Double.NaN));
			tpv.setAltitude(json.optDouble("alt", Double.NaN));
			tpv.setLongitudeError(json.optDouble("epx", Double.NaN));
			tpv.setLatitudeError(json.optDouble("epy", Double.NaN));
			tpv.setAltitudeError(json.optDouble("epv", Double.NaN));
			tpv.setCourse(json.optDouble("track", Double.NaN));
			tpv.setSpeed(json.optDouble("speed", Double.NaN));
			tpv.setClimbRate(json.optDouble("climb", Double.NaN));
			tpv.setCourseError(json.optDouble("epd", Double.NaN));
			tpv.setSpeedError(json.optDouble("eps", Double.NaN));
			tpv.setClimbRateError(json.optDouble("epc", Double.NaN));
			tpv.setMode(ENMEAMode.fromInt(json.optInt("mode", 0)));
			gps = tpv;
		} else if ("SKY".equals(clazz)) {
			final SKYObject sky = new SKYObject();
			sky.setTag(json.optString("tag", null));
			sky.setDevice(json.optString("device", null));
			sky.setTimestamp(this.parseTimestamp(json, "time"));
			sky.setLongitudeDOP(json.optDouble("xdop", Double.NaN));
			sky.setLatitudeDOP(json.optDouble("ydop", Double.NaN));
			sky.setAltitudeDOP(json.optDouble("vdop", Double.NaN));
			sky.setTimestampDOP(json.optDouble("tdop", Double.NaN));
			sky.setHorizontalDOP(json.optDouble("hdop", Double.NaN));
			sky.setSphericalDOP(json.optDouble("pdop", Double.NaN));
			sky.setHypersphericalDOP(json.optDouble("gdop", Double.NaN));
			sky.setSatellites(this.parseObjectArray(json.optJSONArray("satellites"), SATObject.class));
			gps = sky;
		} else if ("GST".equals(clazz)) {
			final GSTObject gst = new GSTObject();
			gst.setTag(json.optString("tag", null));
			gst.setDevice(json.optString("device", null));
			gst.setTimestamp(this.parseTimestamp(json, "time"));
			gst.setRms(json.optDouble("rms", Double.NaN));
			gst.setMajor(json.optDouble("major", Double.NaN));
			gst.setMinor(json.optDouble("minor", Double.NaN));
			gst.setOrient(json.optDouble("orient", Double.NaN));
			gst.setLat(json.optDouble("lat", Double.NaN));
			gst.setLon(json.optDouble("lon", Double.NaN));
			gst.setAlt(json.optDouble("alt", Double.NaN));
			gps = gst;
		} else if ("ATT".equals(clazz)) {
			final ATTObject att = new ATTObject();
			att.setTag(json.optString("tag", null));
			att.setDevice(json.optString("device", null));
			att.setTimestamp(this.parseTimestamp(json, "time"));
			att.setHeading(json.optDouble("heading", Double.NaN));
			att.setPitch(json.optDouble("pitch", Double.NaN));
			att.setYaw(json.optDouble("yaw", Double.NaN));
			att.setRoll(json.optDouble("roll", Double.NaN));
			att.setDip(json.optDouble("dip", Double.NaN));
			att.setMag_len(json.optDouble("mag_len", Double.NaN));
			att.setMag_x(json.optDouble("mag_x", Double.NaN));
			att.setMag_y(json.optDouble("mag_y", Double.NaN));
			att.setMag_z(json.optDouble("mag_z", Double.NaN));
			att.setAcc_len(json.optDouble("acc_len", Double.NaN));
			att.setAcc_x(json.optDouble("acc_x", Double.NaN));
			att.setAcc_y(json.optDouble("acc_y", Double.NaN));
			att.setAcc_z(json.optDouble("acc_z", Double.NaN));
			att.setGyro_x(json.optDouble("gyro_x", Double.NaN));
			att.setGyro_y(json.optDouble("gyro_y", Double.NaN));
			att.setDepth(json.optDouble("depth", Double.NaN));
			att.setTemperature(json.optDouble("temperature", Double.NaN));
			att.setMagState(json.optString("mag_st", null));
			att.setRollState(json.optString("roll_st", null));
			att.setPitchState(json.optString("pitch_st", null));
			att.setYawState(json.optString("yaw_st", null));
			gps = att;
		} else if ("SUBFRAME".equals(clazz)) {
			final SUBFRAMEObject subframe = new SUBFRAMEObject();
			subframe.setDevice(json.optString("device", null));
			subframe.setMSBs(json.optInt("TOW17"));
			subframe.setSatelliteNumber(json.optInt("tSV"));
			subframe.setSubframeNumber(json.optInt("frame"));
			subframe.setScaled(json.optBoolean("scaled", false));
			subframe.setPageid(json.optInt("pageid"));
			if (json.has("system_message")) {
				subframe.setSystemMessage(json.optString("system_message"));
			} else if (json.has("ALMANAC")) {
				subframe.setAlmanac((ALMANACObject)this.parse(json.optJSONObject("ALMANAC")));
			} else if (json.has("EPHEM1")) {
				subframe.setEphem1((EPHEM1Object)this.parse(json.optJSONObject("EPHEM1")));
			} else if (json.has("EPHEM2")) {
				subframe.setEphem2((EPHEM2Object)this.parse(json.optJSONObject("EPHEM2")));
			} else if (json.has("EPHEM3")) {
				subframe.setEphem3((EPHEM3Object)this.parse(json.optJSONObject("EPHEM3")));
			} else if (json.has("ERD")) {
				subframe.setErd((ERDObject)this.parse(json.optJSONObject("ERD")));
			} else if (json.has("HEALTH")) {
				subframe.setHealth((HEALTHObject)this.parse(json.optJSONObject("HEALTH")));
			} else if (json.has("HEALTH2")) {
				subframe.setHealth2((HEALTH2Object)this.parse(json.optJSONObject("HEALTH2")));
			} else if (json.has("IONO")) {
				subframe.setIono((IONOObject)this.parse(json.optJSONObject("IONO")));
			} else {
				System.err.println("Unknown subframe: " + json.toString());
			}
			gps = subframe;
		} else if ("VERSION".equals(clazz)) {
			final VersionObject ver = new VersionObject();
			ver.setRelease(json.optString("release", null));
			ver.setRev(json.optString("rev", null));
			ver.setProtocolMajor(json.optDouble("proto_major", 0));
			ver.setProtocolMinor(json.optDouble("proto_minor", 0));
			gps = ver;
		} else if ("DEVICES".equals(clazz)) {
			final DevicesObject devs = new DevicesObject();
			devs.setDevices(this.parseObjectArray(json.optJSONArray("devices"), DeviceObject.class));
			gps = devs;
		} else if ("DEVICE".equals(clazz)) {
			final DeviceObject dev = new DeviceObject();
			dev.setPath(json.optString("path", null));
			dev.setActivated(this.parseTimestamp(json, "activated"));
			dev.setDriver(json.optString("driver", null));
			dev.setBps(json.optInt("bps", 0));
			dev.setParity(EParity.fromString(json.optString("parity")));
			dev.setStopbit(json.optInt("stopbit"));
			dev.setNativeMode(json.optInt("native", 0) == 1);
			dev.setCycle(json.optInt("cycle"));
			dev.setMincycle(json.optInt("mincycle"));
			gps = dev;
		} else if ("WATCH".equals(clazz)) {
			final WatchObject watch = new WatchObject();
			watch.setEnable(json.optBoolean("enable", true));
			watch.setDump(json.optBoolean("json", false));
			gps = watch;
		} else if ("POLL".equals(clazz)) {
			System.out.println("POLL RAW: " + json.toString());
			// check this for gpsd version <= 3.5
			// final PollObject poll = new PollObject();
			// poll.setTimestamp(this.parseTimestamp(json, "time"));
			// poll.setActive(json.optInt("active", 0));
			// poll.setFixes(this.parseObjectArray(json.optJSONArray("fixes"), TPVObject.class));
			// poll.setSkyviews(this.parseObjectArray(json.optJSONArray("skyviews"), SKYObject.class));
			// gps = poll;

			// check this for gpsd version > 3.5
			final PollObject poll = new PollObject();
			poll.setTimestamp(json.optDouble("timestamp", Double.NaN));
			poll.setActive(json.optInt("active", 0));
			poll.setFixes(this.parseObjectArray(json.optJSONArray("tpv"), TPVObject.class));
			poll.setSkyviews(this.parseObjectArray(json.optJSONArray("sky"), SKYObject.class));
			poll.setGst(this.parseObjectArray(json.optJSONArray("gst"), GSTObject.class));
			gps = poll;
		} else if (json.has("PRN")) { // SATObject
			final SATObject sat = new SATObject();
			sat.setPRN(json.optInt("PRN", -1));
			sat.setAzimuth(json.optInt("az", -1));
			sat.setElevation(json.optInt("el", -1));
			sat.setSignalStrength(json.optInt("ss", -1));
			sat.setUsed(json.optBoolean("used", false));
			gps = sat;
		} else if (json.has("deltai")) { // ALMANACObject
			final ALMANACObject almanac = new ALMANACObject();
			almanac.setID(json.optInt("ID"));
			almanac.setHealth(json.optInt("Health"));
			almanac.setE(json.optDouble("e", Double.NaN));
			almanac.setToa(json.optInt("toa"));
			almanac.setDeltai(json.optDouble("deltai", Double.NaN));
			almanac.setOmegad(json.optDouble("Omegad", Double.NaN));
			almanac.setSqrtA(json.optDouble("sqrtA", Double.NaN));
			almanac.setOmega0(json.optDouble("Omega0", Double.NaN));
			almanac.setOmega(json.optDouble("omega", Double.NaN));
			almanac.setM0(json.optDouble("M0", Double.NaN));
			almanac.setAf0(json.optDouble("af0", Double.NaN));
			almanac.setAf1(json.optDouble("af1", Double.NaN));
			gps = almanac;
		} else if (json.has("IODC")) { // EPHEM1Object
			final EPHEM1Object emphem1 = new EPHEM1Object();
			emphem1.setWN(json.optInt("WN"));
			emphem1.setIODC(json.optInt("IODC"));
			emphem1.setL2(json.optInt("L2"));
			emphem1.setUra(json.optDouble("ura", Double.NaN));
			emphem1.setHlth(json.optDouble("hlth", Double.NaN));
			emphem1.setL2P(json.optInt("L2P"));
			emphem1.setTgd(json.optDouble("Tgd", Double.NaN));
			emphem1.setToc(json.optInt("toc"));
			emphem1.setAf2(json.optDouble("af2", Double.NaN));
			emphem1.setAf1(json.optDouble("af1", Double.NaN));
			emphem1.setAf0(json.optDouble("af0", Double.NaN));
			gps = emphem1;
		} else if (json.has("Crs")) { // EPHEM2Object
			final EPHEM2Object emphem2 = new EPHEM2Object();
			emphem2.setIODE(json.optInt("IODE"));
			emphem2.setCrs(json.optDouble("Crs", Double.NaN));
			emphem2.setDeltan(json.optDouble("deltan", Double.NaN));
			emphem2.setM0(json.optDouble("M0", Double.NaN));
			emphem2.setCuc(json.optDouble("Cuc", Double.NaN));
			emphem2.setE(json.optDouble("e", Double.NaN));
			emphem2.setCus(json.optDouble("Cus", Double.NaN));
			emphem2.setSqrtA(json.optInt("sqrtA"));
			emphem2.setToe(json.optInt("toe"));
			emphem2.setFIT(json.optInt("FIT"));
			emphem2.setAODO(json.optInt("AODO"));
			gps = emphem2;
		} else if (json.has("IDOT")) { // EPHEM3Object
			final EPHEM3Object emphem3 = new EPHEM3Object();
			emphem3.setIODE(json.optInt("IODE"));
			emphem3.setIDOT(json.optDouble("IDOT", Double.NaN));
			emphem3.setCic(json.optDouble("Cic", Double.NaN));
			emphem3.setOmega0(json.optDouble("Omega0", Double.NaN));
			emphem3.setCis(json.optDouble("Cis", Double.NaN));
			emphem3.setI0(json.optDouble("i0", Double.NaN));
			emphem3.setCrc(json.optDouble("Crc", Double.NaN));
			emphem3.setOmega(json.optDouble("omega", Double.NaN));
			emphem3.setOmegad(json.optDouble("Omegad", Double.NaN));
			gps = emphem3;
		} else if (json.has("ERD30")) { // ERDObject
			final ERDObject erd = new ERDObject();
			erd.setAi(json.optInt("ai"));
			for (int index = 1; index <= 30; index++) {
				erd.setERDbyIndex(index - 1, json.optInt("ERD" + index));
			}
			gps = erd;
		} else if (json.has("SVH32")) { // HEALTHObject
			final HEALTHObject health = new HEALTHObject();
			health.setData_id(json.optInt("data_id"));
			for (int index = 1; index <= 32; index++) {
				health.setSVbyIndex(index - 1, json.optInt("SV" + index));
			}
			for (int index = 0; index <= 7; index++) {
				health.setSVHbyIndex(index, json.optInt("SVH" + (index + 25)));
			}
			gps = health;
		} else if (json.has("WNa")) { // HEALTH2Object
			final HEALTH2Object health2 = new HEALTH2Object();
			health2.setToa(json.optInt("toa"));
			health2.setWNa(json.optInt("WNa"));
			for (int index = 1; index <= 24; index++) {
				health2.setSVbyIndex(index - 1, json.optInt("SV" + index));
			}
			gps = health2;
		} else if (json.has("WNlsf")) { // IONOObject
			final IONOObject iono = new IONOObject();
			iono.setAlpha0(json.optDouble("a0", Double.NaN));
			iono.setAlpha1(json.optDouble("a1", Double.NaN));
			iono.setAlpha2(json.optDouble("a2", Double.NaN));
			iono.setAlpha3(json.optDouble("a3", Double.NaN));
			iono.setBeta0(json.optDouble("b0", Double.NaN));
			iono.setBeta1(json.optDouble("b1", Double.NaN));
			iono.setBeta2(json.optDouble("b2", Double.NaN));
			iono.setBeta3(json.optDouble("b3", Double.NaN));
			iono.setA0(json.optDouble("A0", Double.NaN));
			iono.setA1(json.optDouble("A1", Double.NaN));
			iono.setTot(json.optDouble("tot", Double.NaN));
			iono.setWNt(json.optInt("WNt"));
			iono.setLeap(json.optInt("ls"));
			iono.setWNlsf(json.optInt("WNlsf"));
			iono.setDN(json.optInt("DN"));
			iono.setLsf(json.optInt("lsf"));
			gps = iono;
		} else {
			throw new ParseException("Invalid object class: " + clazz);
		}
		return gps;
	}

	private double parseTimestamp(final JSONObject json, final String fieldName) {
		try {
			final String text = json.optString(fieldName, null);
			ResultParser.log.log(Level.FINE, fieldName + ": {0}", text);

			if (text != null) {
				final Date date = this.dateFormat.parse(text);
				if (ResultParser.log.isLoggable(Level.FINE)) {
					ResultParser.log.log(Level.FINE, "Date: {0}", DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(date));
				}
				return (date.getTime() / 1000.0);
			}
		} catch (final Exception ex) {
			ResultParser.log.log(Level.INFO, "Failed to parse time", ex);
		}
		return Double.NaN;
	}
}
