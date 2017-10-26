package com.sample.sam.network_factory;

import com.google.gson.Gson;

/**
 * Created by sam on 10/26/17.
 * service1 detail info returned from server
 */

public class Service1DetailBean {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this).toString();
    }

    private String name;
    private String introduction;


}
