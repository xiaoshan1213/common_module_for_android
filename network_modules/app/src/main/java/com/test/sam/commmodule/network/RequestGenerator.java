package com.test.sam.commmodule.network;

import android.support.annotation.NonNull;

import okhttp3.Request;

/**
 * Created by sam on 7/3/17.
 */

public class RequestGenerator {

    private static void addDefaultHeaders(@NonNull Request.Builder builder){
        builder.header("Accept", "application/json");
    }

    public static Request get(String url){

        Request.Builder builder = new Request.Builder().url(url);
        addDefaultHeaders(builder);
        return builder.build();
    }

}
