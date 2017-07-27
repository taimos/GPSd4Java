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
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.json.JSONObject;

import de.taimos.gpsd4java.types.IGPSObject;
import de.taimos.gpsd4java.types.ParseException;
import de.taimos.gpsd4java.types.PollObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;

/**
 * This class is used to parse responses from GPSd<br>
 * @deprecated use ResultParser; it handles old fields correctly
 *
 * @author thoeger
 */
@Deprecated
public class LegacyResultParser extends ResultParser {
	
	@Override
	protected IGPSObject parsePOLL(final JSONObject json) throws ParseException {
		IGPSObject gps;
		// check this for gpsd version <= 3.5
		final PollObject poll = new PollObject();
		poll.setTimestamp(this.parseTimestamp(json, "time"));
		poll.setActive(json.optInt("active", 0));
		poll.setFixes(this.parseObjectArray(json.optJSONArray("fixes"), TPVObject.class));
		poll.setSkyviews(this.parseObjectArray(json.optJSONArray("skyviews"), SKYObject.class));
		gps = poll;
		return gps;
	}
	
}
