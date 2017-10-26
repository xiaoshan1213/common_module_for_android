package com.sample.sam.network_factory;

import rx.Subscriber;

/**
 * Created by sam on 10/26/17.
 */

public class ResultView {

    private void getDetail(String userId){

        Service1PresenterImpl service1Impl = new Service1PresenterImpl();
        service1Impl.getService1Data(new Subscriber<Service1DetailBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Service1DetailBean service1DetailBean) {
                // update ui here from the serviceDetail1Bean

            }
        }, userId);
    }
}
