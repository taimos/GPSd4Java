package de.taimos.gpsd4java.backend;

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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;

/**
 * 
 * @author irakli, thoeger
 */
public abstract class AbstractResultParser {

	protected static final Logger LOG = Logger.getLogger(ResultParser.class.getName());

	protected final DateFormat dateFormat; // Don't make this static!

	/**
	 * Create new ResultParser
	 */
	public AbstractResultParser() {
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		this.dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * Parse a received line into a {@link IGPSObject}
	 * 
	 * @param line
	 *            the line read from GPSd
	 * @return the parsed object
	 * @throws ParseException
	 *             if parsing fails
	 */
	public IGPSObject parse(final String line) throws ParseException {
		try {
			final JSONObject json = new JSONObject(line);
			return this.parse(json);
		} catch (final JSONException e) {
			throw new ParseException("Parsing failed", e);
		}
	}

	/**
	 * @param json
	 * @return the parsed {@link IGPSObject}
	 * @throws ParseException
	 */
	public abstract IGPSObject parse(final JSONObject json) throws ParseException;

	/**
	 * parse a whole JSONArray into a list of IGPSObjects
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	protected <T extends IGPSObject> List<T> parseObjectArray(final JSONArray array, final Class<T> type) throws ParseException {
		try {
			if (array == null) {
				return new ArrayList<T>(10);
			}
			final List<T> objects = new ArrayList<T>(10);
			for (int i = 0; i < array.length(); i++) {
				objects.add((T) this.parse(array.getJSONObject(i)));
			}
			return objects;
		} catch (final JSONException e) {
			throw new ParseException("Parsing failed", e);
		}
	}

	protected double parseTimestamp(final JSONObject json, final String fieldName) {
		try {
			final String text = json.optString(fieldName, null);
			AbstractResultParser.LOG.log(Level.FINE, fieldName + ": {0}", text);

			if (text != null) {
				final Date date = this.dateFormat.parse(text);
				if (AbstractResultParser.LOG.isLoggable(Level.FINE)) {
					final String ds = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(date);
					AbstractResultParser.LOG.log(Level.FINE, "Date: {0}", ds);
				}
				return date.getTime() / 1000.0;
			}
		} catch (final Exception ex) {
			AbstractResultParser.LOG.log(Level.INFO, "Failed to parse time", ex);
		}
		return Double.NaN;
	}
}
