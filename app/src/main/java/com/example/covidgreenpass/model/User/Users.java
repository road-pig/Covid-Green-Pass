package com.example.covidgreenpass.model.User;

import android.content.res.Resources;

import com.example.covidgreenpass.MainActivity;
import com.example.covidgreenpass.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public static ArrayList<User> users = new ArrayList<>();
    public static User loggedInUser;
    public static boolean loggedIn;
    public static void readUsers(MainActivity mainActivity){
        Resources res = mainActivity.getResources();
        InputStream inputStream = res.openRawResource(R.raw.users);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String[] info = scanner.nextLine().split(",");
            if (info.length == 14&&info[13].equals(true)) {
                loggedInUser = new User(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10], info[11].equals("true"), info[12].equals("true"));
                loggedIn = true;
                continue;
            }
            users.add(new User(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10], info[11].equals("true"), info[12].equals("true")));
        }
        scanner.close();
    }
    public static void writeUsers(MainActivity mainActivity){
        File file = new File(mainActivity.getFilesDir(), "users.csv");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(loggedInUser.toString() + ",true");
            for(int i = 0; i < users.size(); i++){
                printWriter.write(users.get(i).toString());
            }
        } catch (FileNotFoundException e){
            createFile(mainActivity);
            writeUsers(mainActivity);
        }
    }
    public static boolean login(String username, String password){
        User user;
        for(int i = 0; i < users.size(); i++){
            user = users.get(i);
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                loggedInUser = user;
                users.remove(user);
                loggedIn = true;
                return true;
            }
        }
        return false;
    }
    private static void createFile(MainActivity mainActivity){
        try {
            new File(mainActivity.getFilesDir(), "users.csv").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
