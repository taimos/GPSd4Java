About GPSd4Java
===============

GPSd4Java is a library to use data from the GPSd daemon in your Java applications. 
It provides a library to connect to gpsd and retrieve data using a socket connection.

Use GPSd4Java
=============

You can use GPSd4Java with a Maven project. Just add the following lines to your pom.xml.

	<dependencies>
		<dependency>
			<groupId>de.taimos</groupId>
			<artifactId>gpsd4java</artifactId>
			<version>1.7</version>
		</dependency>
	</dependencies>


Getting Started
===============

The main entrypoint to use GPSd4Java is the class `GPSdEndpoint`. 
You can create a new instance by providing the host and port of the gpsd daemon.
Further you have to provide a `ResultParser` instance which parses all messages sent by the GPS device.

On the created endpoint you can then add listeners to handle incoming messages.
This listener will receive the message on the appropriate method according to the message type.
The most interesting messages are the `TPVObjects` as they contain the positional information provided by the GPS device.

To get the position you just have to call the `getLatitude()` and `getLongitude()` methods on the received `TPVObject`.

If all is set you activate the endpoint using the `start()` method.

If this succeeds you can either poll gpsd for new messages or you can enable the watch mode to receive new data on arrival.

## Polling data

To poll single messages call the `poll()` method on the endpoint instance

## Activating watch mode
 
To get all new messages call the `watch(boolean, boolean)` method.
The first param defines if you want enable or disable the watch mode and the second defines if you want to receive messega details.
So the default use case would be to call `watch(true, true)`.

You should now receive incoming messages in your provided listener implementation.
