package com.example.masssportsnews.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class Profile extends ParseUser {

    public static final String KEY_FIRSTNAME = "firstName";
    public static final String KEY_LASTNAME = "lastName";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENUMBER = "phoneNumber";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PASSWORD = "password";

    public String getKeyUsername()
    {
        return getUsername();
    }

    public void setKeyUsername(String username)
    {
        setUsername(username);
    }

    public void setKeyPassword(String password)
    {
        setPassword(password);
    }

    public String getKeyFirstname() {
        return getString(KEY_FIRSTNAME);
    }
    public void setKeyFirstname(String firstname){
        put(KEY_FIRSTNAME, firstname);
    }


    public String getKeyLastname() {
        return getString(KEY_LASTNAME);
    }
    public void setKeyLastname(String lastname){
        put(KEY_LASTNAME, lastname);
    }


    public String getKeyEmail(){
        return getEmail();
    }
    public void setKeyEmail(String email) {
        setEmail(email);
    }

    public String getKeyPhoneNumber(){
        return getString(KEY_PHONENUMBER);
    }
    public void setKeyPhoneNumber(String phoneNumber){
        put(KEY_PHONENUMBER, phoneNumber);
    }


    public String getKeyAddress(){
        return getString(KEY_ADDRESS);
    }
    public void setKeyAddress(String address){
        put(KEY_ADDRESS, address);
    }

}

