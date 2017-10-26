package com.sample.sam.network_factory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sam on 10/26/17.
 */

public class ServiceFactory {

    public static final String BASE_URL = "http;//...";

    public static <T> T createApi(String baseUrl, Class<T> api){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(api);
    }

    public static Service1Api createService1(){
        return createApi(BASE_URL, Service1Api.class);
    }
}
