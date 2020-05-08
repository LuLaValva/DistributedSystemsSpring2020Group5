package com.thoughtmechanix.users.model;
import java.util.HashMap;
import java.util.Map;

public class UserList {
    HashMap<String, User> users;

    public UserList(){
        users = new HashMap<String, User>();
    }

    public User putUser(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public User deleteUser(String username) {
        // Removes this user from all challenge requests for other users
        users.forEach((name, user) -> user.removeChallenger(username));
        return users.remove(username);
    }
}
