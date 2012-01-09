/**
 * Copyright 2011 Thorsten Höger, Taimos GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.taimos.gpsd4java.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import de.taimos.gpsd4java.types.DeviceObject;
import de.taimos.gpsd4java.types.DevicesObject;
import de.taimos.gpsd4java.types.ENMEAMode;
import de.taimos.gpsd4java.types.EParity;
import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.VersionObject;
import de.taimos.gpsd4java.types.WatchObject;

/**
 * This class is used to parse responses from GPSd<br>
 * 
 * @author thoeger
 */
public class ResultParser extends AbstractResultParser {

	private static final Logger log = Logger.getLogger(ResultParser.class.getName());
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Don't make this static!

	/**
	 * Create new ResultParser
	 */
	public ResultParser() {
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
			tpv.setTimestamp(this.parseTimestamp(json));
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
			// TODO implement SKY object
			gps = sky;
		} else if ("ATT".equals(clazz)) {
			// TODO implement ATT object
			throw new ParseException("object class not yet implemented: ATT");
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
			dev.setActivated(json.optDouble("activated", Double.NaN));
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
			final PollObject poll = new PollObject();
			poll.setTimestamp(json.optDouble("timestamp", Double.NaN));
			poll.setActive(json.optInt("active", 0));
			poll.setFixes(this.parseObjectArray(json.optJSONArray("fixes"), TPVObject.class));
			poll.setSkyviews(this.parseObjectArray(json.optJSONArray("skyviews"), SKYObject.class));
			gps = poll;
		} else {
			throw new ParseException("Invalid object class: " + clazz);
		}

		return gps;
	}

	private double parseTimestamp(final JSONObject json) {
		try {
			final String text = json.optString("time", null);
			log.log(Level.FINE, "time: {0}", text);

			if (text != null) {
				final Date date = this.dateFormat.parse(text);
				if (log.isLoggable(Level.FINE)) {
					log.log(Level.FINE, "Date: {0}", DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(date));
				}
				return (date.getTime() / 1000.0);
			}
		} catch (final Exception ex) {
			log.log(Level.INFO, "Failed to parse time", ex);
		}
		return Double.NaN;
	}
}
