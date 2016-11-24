package com.example.myapplication.base;

import rx.Subscriber;

/**
 * Created by 00224524 on 2016/11/24.
 */

public class SubscriberCallback<T> extends Subscriber<T> {
    private ApiCallback<T> mApiCallback;

    public SubscriberCallback(ApiCallback<T> apiCallback) {
        this.mApiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        mApiCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mApiCallback.onError(e);
    }

    @Override
    public void onNext(T t) {
        mApiCallback.onNext(t);
    }
}
