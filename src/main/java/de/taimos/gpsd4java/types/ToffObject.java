package de.taimos.gpsd4java.types;

/**
 * @author dpishchukhin
 */
public class ToffObject implements IGPSObject {
    /**
     * the TOFF internal name
     */
    public static final String NAME = "TOFF";

    private String device = null;

    private double realSec = Double.NaN;

    private double realNsec = Double.NaN;

    private double clockSec = Double.NaN;

    private double clockNsec = Double.NaN;

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
     * seconds from the GPS clock
     *
     * @return seconds
     */
    public double getRealSec() {
        return realSec;
    }

    /**
     * seconds from the GPS clock
     *
     * @param realSec seconds
     */
    public void setRealSec(double realSec) {
        this.realSec = realSec;
    }

    /**
     * nanoseconds from the GPS clock
     *
     * @return nanoseconds
     */
    public double getRealNsec() {
        return realNsec;
    }

    /**
     * nanoseconds from the GPS clock
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
}
