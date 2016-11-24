package com.example.myapplication.base;

/**
 * Created by 00224524 on 2016/11/24.
 */

public interface ApiCallback<T> {
    void onCompleted();

    void onError(Throwable e);

    void onNext(T t);
}
