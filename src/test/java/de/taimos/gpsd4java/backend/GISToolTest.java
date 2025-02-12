package de.taimos.gpsd4java.backend;

import de.taimos.gpsd4java.types.TPVObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GISToolTest {

  @Test
  public void testDistance() {

    // the distance between 1,1 and 2,2 is about 157 kilometers

    final TPVObject one = Mockito.mock(TPVObject.class);
    Mockito.when(one.getLongitude()).thenReturn(1.0);
    Mockito.when(one.getLatitude()).thenReturn(1.0);

    final TPVObject two = Mockito.mock(TPVObject.class);
    Mockito.when(two.getLongitude()).thenReturn(2.0);
    Mockito.when(two.getLatitude()).thenReturn(2.0);

    Assert.assertEquals(157.2254320380729, GISTool.getDistance(one, two), 0.0);

    Assert.assertEquals(0, GISTool.getDistance(one, one), 0.0);
    Assert.assertEquals(0, GISTool.getDistance(two, two), 0.0);
  }
}
