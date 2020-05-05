package com.thoughtmechanix.users.services;

import com.thoughtmechanix.users.model.User;
import com.thoughtmechanix.users.model.UserList;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private UserList users;

    public UserService(){
        users = new UserList();
    }

    public User getUser(String username, String password){
        User user = users.getUser(username);
        if (user == null) {
            return users.putUser(new User().withUsername(username).withPassword(password));
        }
        if (password.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    public void saveUser(User user){

    }

    public void updateUser(User user){

    }

    public void deleteUser(User user){

    }

}
