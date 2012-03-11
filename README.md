About GPSd4Java
===============

GPSd4Java is a library to use data from the GPSd deamon in your java applications. It provides a library to connect to GPSd and retrieve data.

This project started in January 2011 so there is not many information available yet. You may help and contribute if you want.

Use GPSd4Java
=============

You can use GPSd4Java with a Maven project. Just add the following lines to your pom.xml.

	<repositories>
		<repository>
			<id>hoegergroup-repo</id>
			<name>Repository on forge.hoegergroup.de</name>
			<url>http://maven.forge.hoegergroup.de/</url>
		</repository>
	</repositories>

	<dependencies>
		<dependency>
			<groupId>de.taimos</groupId>
			<artifactId>gpsd4java</artifactId>
			<version>1.0.0</version>
		</dependency>
	</dependencies>