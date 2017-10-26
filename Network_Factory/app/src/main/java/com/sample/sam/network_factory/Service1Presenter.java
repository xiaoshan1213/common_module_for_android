package com.sample.sam.network_factory;

import rx.Subscriber;

/**
 * Created by sam on 10/26/17.
 */

public interface Service1Presenter {

    void getService1Data(Subscriber<Service1DetailBean> subscriber, String userId);
}
