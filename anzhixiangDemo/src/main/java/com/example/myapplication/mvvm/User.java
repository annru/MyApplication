package com.example.myapplication.mvvm;

/**
 * Created by 00224524 on 2016/6/30.
 * 描述：
 */
public class User {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
