package com.carrental.Services;

import com.carrental.DAO.IUserCSVDataAccessObject;
import com.carrental.DAO.UserDAO;
import com.carrental.Models.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Validate User ID given as input
    public boolean isValidUserId(String userId){
        return userDAO.isValidUserId(userId);
    }

    public void displayAvailableUsers() {
        var allUsers = userDAO.getAvailableUsers();
        //display each user
        System.out.println("Available Users:".toUpperCase());
        allUsers.forEach(System.out::println);
    }

    public User getUserById(String userID) {
        if(isValidUserId(userID)){
            return userDAO.getUserById(userID);
        }
        return null;  //ToDo: check if this is okay, or may should do try/catch
    }
}
