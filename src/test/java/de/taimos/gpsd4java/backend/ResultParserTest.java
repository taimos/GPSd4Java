package de.taimos.gpsd4java.backend;

import de.taimos.gpsd4java.types.ENMEAMode;
import de.taimos.gpsd4java.types.SATObject;
import de.taimos.gpsd4java.types.SKYObject;
import de.taimos.gpsd4java.types.TPVObject;
import de.taimos.gpsd4java.types.subframes.IONOObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultParserTest {

  private ResultParser resultParser;

  @Before
  public void before() {
    this.resultParser = new ResultParser();
  }

  @Test
  public void testSatObject() {
    final JSONObject json = new JSONObject();
    json.put("PRN", 12);
    json.put("gnssid", 44);
    json.put("svid", 12);
    json.put("az", 229);
    json.put("el", 24);
    json.put("prRes", 22.9);
    json.put("qual", 1);
    json.put("ss", 0);
    json.put("used", false);
    json.put("health", 1);
    final SATObject satObject = (SATObject) this.resultParser.parsePRN(json);
    Assert.assertEquals(12, satObject.getPRN());
    Assert.assertEquals(44, satObject.getGnssId());
    Assert.assertEquals(229, satObject.getAzimuth());
    Assert.assertEquals(24, satObject.getElevation());
    Assert.assertFalse(satObject.getUsed());
    Assert.assertEquals(0, satObject.getSignalStrength());
  }

  @Test
  public void testIonoObject() {
    final JSONObject json = new JSONObject();
    json.put("a0", 1.0);
    json.put("a1", 2.0);
    json.put("a2", 3.0);
    json.put("b0", 11.0);
    json.put("b1", 12.0);
    json.put("b2", 13.0);
    json.put("b3", 14.0);
    json.put("A0", 21.0);
    json.put("A1", 22.0);
    json.put("tot", 31.0);
    json.put("WNt", 100);
    json.put("ls", 101);
    json.put("WNlsf", 102);
    json.put("DN", 103);
    json.put("lsf", 104);
    final IONOObject ionoObject = (IONOObject) this.resultParser.parseIONO(json);
    Assert.assertEquals(1.0, ionoObject.getAlpha0(), 0);
    Assert.assertEquals(2.0, ionoObject.getAlpha1(), 0);
    Assert.assertEquals(3.0, ionoObject.getAlpha2(), 0);
    Assert.assertEquals(11.0, ionoObject.getBeta0(), 0);
    Assert.assertEquals(12.0, ionoObject.getBeta1(), 0);
    Assert.assertEquals(13.0, ionoObject.getBeta2(), 0);
    Assert.assertEquals(14.0, ionoObject.getBeta3(), 0);
    Assert.assertEquals(21.0, ionoObject.getA0(), 0);
    Assert.assertEquals(22.0, ionoObject.getA1(), 0);
    Assert.assertEquals(31.0, ionoObject.getTot(), 0);
    Assert.assertEquals(100, ionoObject.getWNt());
    Assert.assertEquals(101, ionoObject.getLeap());
    Assert.assertEquals(102, ionoObject.getWNlsf());
    Assert.assertEquals(103, ionoObject.getDN());
    Assert.assertEquals(104, ionoObject.getLsf());
  }

  @Test
  public void testSkyObject() throws Exception {

    final JSONObject json = new JSONObject();
    json.put("device", "/dev/ttyUSB0");
    json.put("time", "2025-02-11T08:39:29.000Z");
    json.put("gdop", 1.29);
    json.put("hdop", 0.61);
    json.put("pdop", 1.16);
    json.put("tdop", 0.56);
    json.put("xdop", 0.38);
    json.put("ydop", 0.49);
    json.put("vdop", 0.99);
    json.put("nSat", 2);

    final JSONArray satellites = new JSONArray();
    json.put("satellites", satellites);

    final JSONObject sat1 = new JSONObject();
    sat1.put("PRN", 6);
    sat1.put("gnssid", 0);
    sat1.put("svid", 6);
    sat1.put("az", 110.0);
    sat1.put("el", 2.0);
    sat1.put("prRes", 11.0);
    sat1.put("qual", 1);
    sat1.put("ss", 0.0);
    sat1.put("used", false);
    sat1.put("health", 1);

    final JSONObject sat2 = new JSONObject();
    sat2.put("PRN", 10);
    sat2.put("gnssid", 0);
    sat2.put("svid", 10);
    sat2.put("az", 303.0);
    sat2.put("el", 14.0);
    sat2.put("prRes", 30.3);
    sat2.put("qual", 7);
    sat2.put("ss", 48.0);
    sat2.put("used", true);
    sat2.put("health", 1);

    satellites.put(sat1);
    satellites.put(sat2);

    final SKYObject skyObject = (SKYObject) this.resultParser.parseSKY(json);

    Assert.assertEquals("/dev/ttyUSB0", skyObject.getDevice());
    Assert.assertEquals(1739263169.0, skyObject.getTimestamp(), 0.0);
    Assert.assertEquals(1.29, skyObject.getHypersphericalDOP(), 0.0);
    Assert.assertEquals(0.61, skyObject.getHorizontalDOP(), 0.0);
    Assert.assertEquals(1.16, skyObject.getSphericalDOP(), 0.0);
    Assert.assertEquals(0.56, skyObject.getTimestampDOP(), 0.0);
    Assert.assertEquals(0.38, skyObject.getLongitudeDOP(), 0.0);
    Assert.assertEquals(0.49, skyObject.getLatitudeDOP(), 0.0);
    Assert.assertEquals(0.99, skyObject.getAltitudeDOP(), 0.0);
    Assert.assertEquals(2, skyObject.getSatellites().size());

    final SATObject satObject1 = skyObject.getSatellites().get(0);
    Assert.assertEquals(6, satObject1.getPRN());
    Assert.assertEquals(0, satObject1.getGnssId());
    Assert.assertEquals(110.0, satObject1.getAzimuth(), 0.0);
    Assert.assertEquals(2.0, satObject1.getElevation(), 0.0);
    Assert.assertEquals(0.0, satObject1.getSignalStrength(), 0.0);
    Assert.assertFalse(satObject1.getUsed());

    final SATObject satObject2 = skyObject.getSatellites().get(1);
    Assert.assertEquals(10, satObject2.getPRN());
    Assert.assertEquals(0, satObject2.getGnssId());
    Assert.assertEquals(303.0, satObject2.getAzimuth(), 0.0);
    Assert.assertEquals(14.0, satObject2.getElevation(), 0.0);
    Assert.assertEquals(48.0, satObject2.getSignalStrength(), 0.0);
    Assert.assertTrue(satObject2.getUsed());
  }

  @Test
  public void testTpvObject() {

    final JSONObject json = new JSONObject();
    json.put("tag", "tag");
    json.put("alt", 136.054);
    json.put("epv", 0.835);
    json.put("device", "/dev/ttyUSB0");
    json.put("time", "2025-02-11T08:39:29.000Z");
    json.put("ept", 0.005);
    json.put("lat", 42.7045841);
    json.put("lon", 12.1588884);
    json.put("alt", 136.054);
    json.put("epx", 1.411);
    json.put("epy", 1.822);
    json.put("epv", 0.835);
    json.put("track", 144.6175);
    json.put("speed", 22.693);
    json.put("climb", 0.023);
    json.put("epd", 9.1852);
    json.put("eps", 3.51);
    json.put("epc", 1.68);
    json.put("mode", 3);

    final TPVObject tpvObject = (TPVObject) this.resultParser.parseTPV(json);
    Assert.assertEquals(136.054, tpvObject.getAltitude(), 0);
    Assert.assertEquals(0.835, tpvObject.getAltitudeError(), 0);
    Assert.assertEquals(0.023, tpvObject.getClimbRate(), 0);
    Assert.assertEquals(1.68, tpvObject.getClimbRateError(), 0);
    Assert.assertEquals(144.6175, tpvObject.getCourse(), 0);
    Assert.assertEquals(9.1852, tpvObject.getCourseError(), 0);
    Assert.assertEquals("/dev/ttyUSB0", tpvObject.getDevice());
    Assert.assertEquals(42.7045841, tpvObject.getLatitude(), 0);
    Assert.assertEquals(1.822, tpvObject.getLatitudeError(), 0);
    Assert.assertEquals(12.1588884, tpvObject.getLongitude(), 0);
    Assert.assertEquals(1.411, tpvObject.getLongitudeError(), 0);
    Assert.assertEquals(ENMEAMode.ThreeDimensional, tpvObject.getMode());
    Assert.assertEquals(22.693, tpvObject.getSpeed(), 0);
    Assert.assertEquals(3.51, tpvObject.getSpeedError(), 0);
    Assert.assertEquals("tag", tpvObject.getTag());
    Assert.assertEquals(1739263169.0, tpvObject.getTimestamp(), 0);
    Assert.assertEquals(0.005, tpvObject.getTimestampError(), 0);
  }
}
