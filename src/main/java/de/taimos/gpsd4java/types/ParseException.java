package de.taimos.gpsd4java.types;

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

/**
 * {@link Exception} indication an error while parsing the GPSd line
 *
 * @author thoeger
 */
public class ParseException extends Exception {
	
	private static final long serialVersionUID = 7747422116792199432L;
	
	/**
	 *
	 */
	public ParseException() {
		super();
	}
	
	/**
	 * @param message the message
	 */
	public ParseException(final String message) {
		super(message);
	}
	
	/**
	 * @param message the message
	 * @param cause   the cause
	 */
	public ParseException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param cause the cause
	 */
	public ParseException(final Throwable cause) {
		super(cause);
	}
	
}
