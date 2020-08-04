package com.taveeshsharma.httprequesthandler.utils;

public class Constants {
    public static final String BAD_REQUEST = "Bad request";
    public static enum RequestType {SCHEDULE_MEASUREMENT, CHECKIN};
    public static enum MeasurementType {PING, DNS_LOOKUP, HTTP, TCP_SPEED_TEST, TRACE_ROUTE};
    public static final String TCP_TYPE = "tcp_speed_test",
                               PING_TYPE = "ping",
                               DNS_TYPE = "dns_lookup",
                               HTTP_TYPE = "http",
                               TRACERT_TYPE = "traceroute";

}