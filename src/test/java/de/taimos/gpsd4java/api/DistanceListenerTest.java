package de.taimos.gpsd4java.api;

import de.taimos.gpsd4java.types.TPVObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DistanceListenerTest {

  @Test
  public void testDistanceListener() {

    final boolean[] called = new boolean[1];

    final DistanceListener distanceListener =
        new DistanceListener(100.0) {
          @Override
          protected void handleLocation(final TPVObject tpv) {
            called[0] = true;
          }
        };

    final TPVObject tpvObject1 = Mockito.mock(TPVObject.class);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(1.0);
    Mockito.when(tpvObject1.getLatitude()).thenReturn(1.0);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(1.0);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(1.0);

    final TPVObject tpvObject2 = Mockito.mock(TPVObject.class);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(2.0);
    Mockito.when(tpvObject1.getLatitude()).thenReturn(2.0);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(2.0);
    Mockito.when(tpvObject1.getLongitude()).thenReturn(2.0);

    // first call, lastPosition is null, should call handleLocation
    called[0] = false;
    distanceListener.handleTPV(tpvObject1);
    Assert.assertTrue(called[0]);

    // second call, lastPosition is set, same position so no call
    called[0] = false;
    distanceListener.handleTPV(tpvObject1);
    Assert.assertFalse(called[0]);

    // third call, lastPosition is set, other position so should call
    called[0] = false;
    distanceListener.handleTPV(tpvObject2);
    Assert.assertTrue(called[0]);
  }
}
