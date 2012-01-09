package de.taimos.gpsd4java.backend;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;

/**
 * 
 * @author irakli
 */
public abstract class AbstractResultParser {

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
	@SuppressWarnings("unchecked")
	protected <T extends IGPSObject> List<T> parseObjectArray(final JSONArray array, final Class<T> componentType) throws ParseException {
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
}
