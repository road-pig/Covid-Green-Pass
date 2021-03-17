package com.example.covidgreenpass.model.QRCode;

import com.example.covidgreenpass.MainActivity;
import com.example.covidgreenpass.model.User.User;

import java.nio.file.Paths;

public class eQRCode extends QRCode {
    private User user;

    public eQRCode(int width, int height, User user) {
        super(width, height);
        this.user = user;
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
                "user=" + user +
                '}';
    }
}
