About GPSd4Java
===============

GPSd4Java is a library to use data from the GPSd daemon in your java applications. It provides a library to connect to GPSd and retrieve data.

Use GPSd4Java with gpsd 3.6
===========================

Version 1.2 is ONLY compatible with gpsd version 3.6. GPSd4Java 1.3 will be a compatibility release to support all active gpsd versions.

	<dependencies>
		<dependency>
			<groupId>de.taimos</groupId>
			<artifactId>gpsd4java</artifactId>
			<version>1.2.0</version>
		</dependency>
	</dependencies>

Use GPSd4Java
=============

You can use GPSd4Java with a Maven project. Just add the following lines to your pom.xml.

	<dependencies>
		<dependency>
			<groupId>de.taimos</groupId>
			<artifactId>gpsd4java</artifactId>
			<version>1.1.0</version>
		</dependency>
	</dependencies>


To get the latest development snapshot add the following lines to your pom.xml.

	<repositories>
		<repository>
			<id>sonatype-nexus-snapshots</id>
			<name>Sonatype Nexus Snapshots</name>
			<url>https://oss.sonatype.org/content/repositories/snapshots/</url>
		</repository>
	</repositories>

	<dependencies>
		<dependency>
			<groupId>de.taimos</groupId>
			<artifactId>gpsd4java</artifactId>
			<version>1.2.0-SNAPSHOT</version>
		</dependency>
	</dependencies>