package com.carrental.DAO;

import com.carrental.Models.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IUserFakerDataAccessService implements UserDAO{
    private final List<User> users = new ArrayList<>();
    private final Faker faker = new Faker();
    private final int NUM_USERS = 6;

    public IUserFakerDataAccessService() {
        generateUsers();
    }

    private void generateUsers() {
        for (int i = 0; i < NUM_USERS; i++) {
            var firstName = faker.name().firstName();
            users.add(new User(firstName));
        }
    }

    @Override
    public List<User> getAvailableUsers() {
       return users;
    }

    @Override
    public boolean isValidUserId(String userId) {
        return users.stream()
                    .anyMatch(user -> user.getUserId().equals(userId));
    }

    @Override
    public User getUserById(String userID) {
        return users.stream()
                    .filter(user -> user.getUserId().equals(userID))
                    .findFirst()
                    .orElse(null);

    }
}
