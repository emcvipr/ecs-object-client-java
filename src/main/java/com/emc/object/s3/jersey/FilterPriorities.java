package com.emc.object.s3.jersey;

import javax.ws.rs.Priorities;

public class FilterPriorities {

    // providers used during request processing (using ascending manner)
    public static final int PRIORITY_NAMESPACE = 1000;
    public static final int PRIORITY_BUCKET = 1100;
    public static final int PRIORITY_GEOPINNING = 1200;
//    public static final int PRIORITY_SMART = 1400;
    public static final int PRIORITY_CHECKSUM_REQUEST = 1500;

    public static final int PRIORITY_AUTHORIZATION = Priorities.AUTHORIZATION; //2000

    // providers used during response processing (using descending manner)
    public static final int PRIORITY_CHECKSUM_RESPONSE = Priorities.ENTITY_CODER; //4000
    public static final int PRIORITY_FAULTINJECTION = Priorities.USER; //5000
    public static final int PRIORITY_ERROR = Priorities.USER; //5000


    private FilterPriorities() {}

}
