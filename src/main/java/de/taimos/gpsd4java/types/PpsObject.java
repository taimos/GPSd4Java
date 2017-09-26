package de.taimos.gpsd4java.types;

/**
 * This message is emitted each time the daemon sees a valid PPS (Pulse Per Second) strobe from a device.
 * This message exactly mirrors the TOFF message except for two details.
 * PPS emits the NTP precision. See the NTP documentation for their definition of precision.
 * The TOFF message reports the GPS time as derived from the GPS serial data stream.
 * The PPS message reports the GPS time as derived from the GPS PPS pulse.
 *
 * @author dpishchukhin
 */
public class PpsObject implements IGPSObject {
    /**
     * the PPS internal name
     */
    public static final String NAME = "PPS";

    private String device = null;

    private double realSec = Double.NaN;

    private double realNsec = Double.NaN;

    private double clockSec = Double.NaN;

    private double clockNsec = Double.NaN;

    private double precision = Double.NaN;

    /**
     * Name of originating device
     *
     * @return device
     */
    public String getDevice() {
        return device;
    }

    /**
     * Name of originating device
     *
     * @param device device
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * seconds from the PPS source
     *
     * @return seconds
     */
    public double getRealSec() {
        return realSec;
    }

    /**
     * seconds from the PPS source
     *
     * @param realSec seconds
     */
    public void setRealSec(double realSec) {
        this.realSec = realSec;
    }

    /**
     * nanoseconds from the PPS source
     *
     * @return nanoseconds
     */
    public double getRealNsec() {
        return realNsec;
    }

    /**
     * nanoseconds from the PPS source
     *
     * @param realNsec nanoseconds
     */
    public void setRealNsec(double realNsec) {
        this.realNsec = realNsec;
    }

    /**
     * seconds from the system clock
     *
     * @return seconds
     */
    public double getClockSec() {
        return clockSec;
    }

    /**
     * seconds from the system clock
     *
     * @param clockSec seconds
     */
    public void setClockSec(double clockSec) {
        this.clockSec = clockSec;
    }

    /**
     * nanoseconds from the system clock
     *
     * @return nanoseconds
     */
    public double getClockNsec() {
        return clockNsec;
    }

    /**
     * nanoseconds from the system clock
     *
     * @param clockNsec nanoseconds
     */
    public void setClockNsec(double clockNsec) {
        this.clockNsec = clockNsec;
    }

    /**
     * NTP style estimate of PPS precision
     *
     * @return precision
     */
    public double getPrecision() {
        return precision;
    }

    /**
     * NTP style estimate of PPS precision
     *
     * @param precision precision
     */
    public void setPrecision(double precision) {
        this.precision = precision;
    }
}
