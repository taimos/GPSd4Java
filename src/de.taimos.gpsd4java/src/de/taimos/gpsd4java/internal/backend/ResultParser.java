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
package de.taimos.gpsd4java.internal.backend;

import org.json.JSONException;
import org.json.JSONObject;

import de.taimos.gpsd4java.types.ENMEAMode;
import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.VersionObject;

/**
 * This class is used to parse responses from GPSd<br>
 * 
 * created: 17.01.2011
 * 
 */
public class ResultParser {
	
	/**
	 * @param line the line read from GPSd
	 * @return the parsed location
	 * @throws ParseException if parsing fails
	 */
	public static IGPSObject parse(String line) throws ParseException {
		JSONObject json = null;
		try {
			json = new JSONObject(line);
			return ResultParser.parse(json);
		} catch (JSONException e) {
			throw new ParseException("Parsing failed", e);
		}
	}
	
	/**
	 * @param json the {@link JSONObject} to parse
	 * @return the parsed location
	 * @throws ParseException if parsing fails
	 */
	public static IGPSObject parse(JSONObject json) throws ParseException {
		IGPSObject gps = null;
		String clazz = json.optString("class");
		
		if (clazz.equals("TPV")) {
			TPVObject tpv = new TPVObject();
			tpv.setTag(json.optString("tag", null));
			tpv.setDevice(json.optString("device", null));
			tpv.setTimestamp(json.optDouble("time", Double.NaN));
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
		} else if (clazz.equals("SKY")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: SKY");
		} else if (clazz.equals("ATT")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: ATT");
		} else if (clazz.equals("VERSION")) {
			VersionObject ver = new VersionObject();
			ver.setRelease(json.optString("release", null));
			ver.setRev(json.optString("rev", null));
			ver.setProtocolMajor(json.optDouble("proto_major", 0));
			ver.setProtocolMinor(json.optDouble("proto_minor", 0));
			gps = ver;
		} else if (clazz.equals("DEVICES")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: DEVICES");
		} else if (clazz.equals("DEVICE")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: DEVICE");
		} else if (clazz.equals("WATCH")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: WATCH");
		} else if (clazz.equals("POLL")) {
			// TODO implement
			throw new ParseException("object class not yet implemented: POLL");
		} else {
			throw new ParseException("Invalid object class: " + clazz);
		}
		return gps;
	}
}
