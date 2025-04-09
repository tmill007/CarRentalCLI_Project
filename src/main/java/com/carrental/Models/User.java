package com.carrental.Models;

import java.util.Objects;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class User {
    private String name;
    private String userId;

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID().toString();
    }

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    /*  NOT ALLOWED TO SET A UUID
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
     */

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userId);
    }
}
