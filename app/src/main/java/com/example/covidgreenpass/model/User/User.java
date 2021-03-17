package com.example.covidgreenpass.model.User;

import androidx.annotation.NonNull;

import com.example.covidgreenpass.MainActivity;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

public class User {
    private String username, password, name, address, contactNo, contactEmail, ID, vaccine, vaccineDate, testResult, testDate;
    private boolean vaccinated, admin;

    public User(String username, String password, String name, String address, String contactNo, String contactEmail, String ID, String vaccine, String vaccineDate, String testDate, String testResult, boolean vaccinated, boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
        this.ID = ID;
        this.vaccine = vaccine;
        this.vaccineDate = vaccineDate;
        this.testDate = testDate;
        this.vaccinated = vaccinated;
        this.admin = admin;
        this.testResult = testResult;
    }

    public User(String username, String password, String name, String address, String contactNo, String contactEmail, String ID, String testDate, String testResult, MainActivity mainActivity) {
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
        this.ID = ID;
        this.vaccine = null;
        this.vaccineDate = null;
        this.testDate = testDate;
        this.testResult = testResult;
    }

    @NonNull
    @Override
    public String toString() {
        return this.username + "," + this.password + "," + this.name + "," + this.address + "," + this.contactNo + "," + this.contactEmail + "," + this.vaccine + "," + this.vaccineDate + "," + this.testResult + "," + this.testDate + "," + "," + this.vaccinated + "," + this.admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
