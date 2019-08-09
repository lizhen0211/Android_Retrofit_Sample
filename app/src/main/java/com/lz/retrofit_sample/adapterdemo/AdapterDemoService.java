package com.lz.retrofit_sample.adapterdemo;

import retrofit2.http.GET;

public interface AdapterDemoService {
    /**
     * http://httpbin.org/ip
     * <p>
     * An object can be specified for use as an HTTP request body with the @Body annotation.
     *
     * @param
     * @return
     */
    @GET("/ip")
    ErrorHandlingAdapter.MyCall<Ip> getIp();
}
