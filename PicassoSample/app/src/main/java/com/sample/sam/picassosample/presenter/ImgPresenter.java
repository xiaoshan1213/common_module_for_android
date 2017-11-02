package com.sample.sam.picassosample.presenter;

import android.content.Context;

import com.sample.sam.picassosample.model.ImgRes;

import rx.Subscriber;

/**
 * Created by sam on 11/2/17.
 */

public interface ImgPresenter {

    void getImages(Context context, Subscriber<ImgRes> subscriber);

}
