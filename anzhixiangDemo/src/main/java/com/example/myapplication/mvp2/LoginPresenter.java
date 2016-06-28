package com.example.myapplication.mvp2;

/**
 * Created by 00224524 on 2016/6/28.
 * 描述：
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
