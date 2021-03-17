package com.example.covidgreenpass.model.User;

import androidx.annotation.NonNull;

import com.example.covidgreenpass.MainActivity;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

public class User {
    private String username, password, name, address, contactNo, contactEmail;
    private Boolean vaccinated;

    public User(String username, String password, String name, String address, String contactNo, String contactEmail, Boolean vaccinated) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
        this.vaccinated = vaccinated;
    }

    public User(String username, String password, String name, String address, String contactNo, String contactEmail, MainActivity mainActivity) {
        if (!contactEmail.matches("^[a-zA-Z]([.-]?\\w+)*[a-zA-Z]?@[a-zA-Z]\\w*(\\.\\w{2,3})+$")){
            throw new IllegalArgumentException("Invalid email!");
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.createInstance(mainActivity);
        try {
            if (!phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(contactNo, null))) {
                throw new IllegalArgumentException("Invalid number!");
            }
        } catch (NumberParseException e){
            throw new IllegalArgumentException("Invalid number!");
        }
        if(address.contains(",")){
            throw new IllegalArgumentException("No commas are allowed in address");
        }
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
        this.vaccinated = false;
    }

    @NonNull
    @Override
    public String toString() {
        return this.username + "," + this.password + "," + this.name + "," + this.address + "," + this.contactNo + "," + this.contactEmail + "," + this.vaccinated;
    }
}
