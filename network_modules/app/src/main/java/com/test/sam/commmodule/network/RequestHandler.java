package com.test.sam.commmodule.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sam on 7/3/17.
 */

public class RequestHandler {

    private OkHttpClient client;

    public RequestHandler(OkHttpClient client){
        this.client = client;
    }

    public String request(Request request) throws IOException {

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        if (response.isSuccessful()){
            Log.d("requstHandler_response", body);
            return body;
        }else{
            throw new RuntimeException(response.message());
        }
    }
}
