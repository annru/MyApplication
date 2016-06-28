package com.example.myapplication.mvp2;

/**
 * Created by 00224524 on 2016/6/28.
 * 描述：
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
