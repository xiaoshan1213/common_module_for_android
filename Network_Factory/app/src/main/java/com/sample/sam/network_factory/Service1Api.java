package com.sample.sam.network_factory;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sam on 10/26/17.
 */

public interface Service1Api {

    @GET("service1/list/detail")
    Observable<Service1DetailBean> getService1Detail(@Header("Authorization") String accessToken,
                                                 @Query("userId") String userId,
                                                 @Query("item1") String item);

    @POST("service1/list")
    Observable<Service1ListBean> getService1List(@Header("Authorization") String accessToken,
                                                 @Query("userId") String userId,
                                                 @Body Service1Req req);

}
