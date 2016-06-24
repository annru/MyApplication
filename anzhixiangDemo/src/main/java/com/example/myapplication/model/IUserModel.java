package com.example.myapplication.model;


public interface IUserModel {
	void setID(int id);

	void setFirstName(String firstName);

	void setLastName(String lastName);

	UserBean load(int id);
}
