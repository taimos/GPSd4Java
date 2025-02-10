package de.taimos.gpsd4java.backend;

import de.taimos.gpsd4java.types.SATObject;
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

}
