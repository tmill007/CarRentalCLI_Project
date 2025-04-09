package com.carrental.DAO;

import com.carrental.Models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAvailableUsers();

    boolean isValidUserId(String userId);

    User getUserById(String userID);
}
