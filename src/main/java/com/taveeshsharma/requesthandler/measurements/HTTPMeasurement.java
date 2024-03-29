package com.taveeshsharma.requesthandler.measurements;


import com.taveeshsharma.requesthandler.utils.Constants;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.util.concurrent.TimeUnit;

/**
 * Http measurement, which extends from the base measurement.
 */
@Measurement(name = Constants.HTTP_TYPE, timeUnit = TimeUnit.MILLISECONDS)
public class HTTPMeasurement extends Measurements {

    @Column(name="time_ms")
    private Double timeTakenMs;

    @Column(name="code")
    private int httpResultCode;

    public Double getTimeTakenMs() {
        return timeTakenMs;
    }

    //getters and etters for the measurements.
    public void setTimeTakenMs(Double timeTakenMs) {
        this.timeTakenMs = timeTakenMs;
    }

    public int getHttpResultCode() {
        return httpResultCode;
    }

    public void setHttpResultCode(int httpResultCode) {
        this.httpResultCode = httpResultCode;
    }

}
