package com.sample.sam.picassosample.utils;

import android.content.Context;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by sam on 11/2/17.
 */

public class CacheManager {

    // remove cached image from url
    private void removeCache(Context context, String url) {

        Picasso.with(context).invalidate(url);
    }

    // get and set cache for the image in url
    private static Observable<Boolean> getImgObservable(final Context context, final String url) {

        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                Picasso.with(context).load(url).fetch(new Callback() {
                    @Override
                    public void onSuccess() {
                        // do something to store url or image
                    }

                    @Override
                    public void onError() {

                    }
                });
            }
        }).observeOn(Schedulers.newThread());
    }
}
