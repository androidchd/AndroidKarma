package com.KarmaLakeLand1;

import java.util.ArrayList;


public class SingletonTasker {


	String address1;
	String catId;
	String city;
	String createDate;
	String emailID;
	String gender;
	String latitude;
	String longitude;
	String  mobileNo;
	String  password;
	String refrealCode;
	String status;
	String  subCatId;
	String userCode;
	String userID;
	String userName;
	String  zipCode;
	ArrayList<Contacts> contacts= new ArrayList<Contacts>();

	private static SingletonTasker instance = new SingletonTasker();


	private SingletonTasker() {
	}
	public static SingletonTasker getInstance() {

		return instance;
	}


	public static void setInstance(SingletonTasker instance) {
		SingletonTasker.instance = instance;
	}
}
