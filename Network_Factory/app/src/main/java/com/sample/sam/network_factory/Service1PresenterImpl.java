package com.sample.sam.network_factory;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sam on 10/26/17.
 */

public class Service1PresenterImpl implements Service1Presenter {

    @Override
    public void getService1Data(Subscriber<Service1DetailBean> subscriber, String userId) {

        ServiceFactory.createService1()
                .getService1Detail(
                        "accessToken",
                        userId,
                        "item1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
