package com.thoughtmechanix.users.services;

import com.thoughtmechanix.users.model.User;
import com.thoughtmechanix.users.model.UserList;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    public static final int UNKNOWN_ERR = -1;
    public static final int SUCCESS = 0;
    public static final int ERR_INVALID_USERNAME = 1;
    public static final int ERR_WRONG_PASSWORD = 2;
    public static final int ERR_CHALLENGED_DNE = 3;
    public static final int ERR_CHALLENGED_NOT_IN_LIST = 4;

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

    public int challenge(String username, String password, String challenged) {
        User user = users.getUser(username);
        if (user == null) {
            return ERR_INVALID_USERNAME;
        }
        if (!password.equals(user.getPassword())) {
            return ERR_WRONG_PASSWORD;
        }
        User user2 = users.getUser(challenged);
        if (user2 == null) {
            return ERR_CHALLENGED_DNE;
        }
        user.addOutgoingChallenger(challenged);
        user2.addIncomingChallenger(username);
        return SUCCESS;
    }

    public int acceptChallenger(String username, String password, String challenger) {
        User user = users.getUser(username);
        if (user == null) {
            return ERR_INVALID_USERNAME;
        }
        if (!password.equals(user.getPassword())) {
            return ERR_WRONG_PASSWORD;
        }
        User user2 = users.getUser(challenger);
        if (user2 == null) {
            return ERR_CHALLENGED_DNE;
        }
        if (!user.acceptChallenger(challenger)) {
            return ERR_CHALLENGED_NOT_IN_LIST;
        }
        if (!user2.challengeAccepted(username)) {
            return UNKNOWN_ERR;
        }
        return SUCCESS;
    }

    public void saveUser(User user){

    }

    public void updateUser(User user){

    }

    public void deleteUser(User user){

    }

}
