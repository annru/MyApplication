package com.example.myapplication.activity.mvp;

public interface IUserView {
    int getID();

    String getFirstName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);

}
