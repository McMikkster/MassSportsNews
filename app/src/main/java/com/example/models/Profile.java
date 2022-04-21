package com.example.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("user")
public class Profile extends ParseObject {

    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENUMBER = "phonenumber";
    public static final String KEY_ADDRESS = "address";

    public String getKeyFirstname() {
        return getString(KEY_FIRSTNAME);
    }
    public void setKeyFirstname(String firstname){
        put(KEY_FIRSTNAME, firstname);
    }


    public  String getKeyLastname() {
        return getString(KEY_LASTNAME);
    }
    public void setKeyLastname(String lastname){
        put(KEY_LASTNAME, lastname);
    }


    public  String getKeyEmail(){
        return getString(KEY_EMAIL);
    }
    public void setKeyEmail(String email) {
        put(KEY_EMAIL, email);
    }

    public  String getKeyPhoneNumber(){
        return getString(KEY_PHONENUMBER);
    }
    public void setKeyPhoneNumber(String phoneNumber){
        put(KEY_PHONENUMBER, phoneNumber);
    }


    public  String getKeyAddress(){
        return getString(KEY_ADDRESS);
    }
    public void setkeyAddress(String address){
        put(KEY_ADDRESS, address);
    }



}

