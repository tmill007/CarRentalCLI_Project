package com.carrental.DAO;

import com.carrental.Models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IUserCSVDataAccessObject implements UserDAO{
    private List<User> users;
    //private String path = "src/com/carrental/users.csv";

     @Override
    public List<User> getAvailableUsers() {
         users = new ArrayList<>();
        String userName;
        String userId;

        try {
            Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream("users.csv"));

            while(scanner.hasNextLine()){
                var input = scanner.nextLine().split(",");
                userName = input[0].trim();
                userId = input[1].trim();
                users.add(new User(userName, userId));

            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Users.csv file not found" + e.getMessage());
        }
        return users;
    }

    public boolean isValidUserId(String userId) {
        return users.stream().anyMatch(user -> user.getUserId().equals(userId));

    }

    public User getUserById(String userID) {
        for(User user : users){
            if(user.getUserId().equals(userID)){
                return user;
            }
        } return null;
    }
}
