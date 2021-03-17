package com.example.covidgreenpass.model.QRCode;

import com.example.covidgreenpass.MainActivity;

import java.nio.file.Paths;

public class eQRCode extends QRCode {
    private String username, password, name, address, contactNo, contactEmail;
    private Boolean vaccinated;

    public eQRCode(int width, int height, String username, String password, String name, String address, String contactNo, String contactEmail, Boolean vaccinated) {
        super(width, height);
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
        this.vaccinated = vaccinated;
    }

    public void generate(MainActivity mainActivity){
        try {
            generateQRCodeImage(toString(), Paths.get("./").toAbsolutePath().relativize(Paths.get(mainActivity.getFilesDir().getAbsolutePath())) + "/" + "current" + ".png");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public String toString() {
        return "eQRCode{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", vaccinated=" + vaccinated +
                '}';
    }
}
