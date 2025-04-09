package com.carrental.DAO;

import com.carrental.Models.User;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class IUserArrayDataAccessObject implements UserDAO{
    private static User[] users;
    private static final int CAPACITY = 5;

    //Initialize 2 static users in the users database
    static{
        users = new User[CAPACITY];
        users[0] = new User("Ronique", "e2cd7a31-f052-4293-b263-7d234c23543b");
        users[1] = new User("Giora", "3c9ce864-76e2-42f0-bfa1-ed94c10d9441");
        users[2] = new User("Tony", UUID.randomUUID().toString());
        users[3] = new User("Gary", UUID.randomUUID().toString());
        users[4] = new User("Tiffany", UUID.randomUUID().toString());
    }


    public boolean isValidUserId(String userId) {
        return Arrays.stream(users).anyMatch(user -> user.getUserId().equals(userId));
    }

    @Override
    public List<User> getAvailableUsers() {
        return Arrays.asList(users);
    }


    public User getUserById(String userID) {

        for(User user : users){
            if(user.getUserId().equals(userID)){
                return user;
            }
        } return null;
    }
}
