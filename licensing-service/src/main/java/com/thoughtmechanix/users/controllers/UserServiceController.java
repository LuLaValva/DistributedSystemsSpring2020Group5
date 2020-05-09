package com.thoughtmechanix.users.controllers;

import com.thoughtmechanix.users.model.User;
import com.thoughtmechanix.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value="user")
public class UserServiceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/{username}/{password}",method = RequestMethod.GET)
    public User getUsers( @PathVariable("username") String username,
                                @PathVariable("password") String password) {

        return userService.getUser(username, password);
    }

    @RequestMapping(value="/{username}/{password}",method = RequestMethod.PUT)
    public String updateUsers( @PathVariable("username") String username,
                                @PathVariable("password") String password) {
        return String.format("This is the put");
    }

    @RequestMapping(value="/{username}/{password}",method = RequestMethod.POST)
    public String saveUsers( @PathVariable("username") String username,
                                @PathVariable("password") String password) {
        return String.format("This is the post");
    }

    @RequestMapping(value="/{username}/{password}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUsers( @PathVariable("username") String username,
                                @PathVariable("password") String password) {
        return String.format("This is the Delete");
    }

    @RequestMapping(value="/{challenger}/{password}/challenge/{challenged}", method = RequestMethod.GET)
    public String challenge(@PathVariable("challenger") String challenger,
                                @PathVariable("password") String password,
                                @PathVariable("challenged") String challenged) {
        switch(userService.challenge(challenger, password, challenged)) {
            case UserService.SUCCESS:
                return "Successfully added challenge from " + challenger + " to " + challenged;
            case UserService.ERR_INVALID_USERNAME:
                return "Invalid Username, try again";
            case UserService.ERR_WRONG_PASSWORD:
                return "Invalid Password, try again";
            case UserService.ERR_CHALLENGED_DNE:
                return "" + challenged + " does not exist. Please enter a valid username.";
            default:
                return "Unknown error";
        }
    }

    @RequestMapping(value="/{username}/{password}/accept/{challenger}", method = RequestMethod.GET)
    public String accept(@PathVariable("username") String username,
                                @PathVariable("password") String password,
                                @PathVariable("challenger") String challenger) {
        switch(userService.acceptChallenger(username, password, challenger)) {
            case UserService.SUCCESS:
                return "Successfully accepted challenge from " + challenger + " to " + username;
            case UserService.ERR_INVALID_USERNAME:
                return "Invalid Username, try again";
            case UserService.ERR_WRONG_PASSWORD:
                return "Invalid Password, try again";
            case UserService.ERR_CHALLENGED_DNE:
                return "" + challenger + " does not exist. Please enter a valid username.";
            case UserService.ERR_CHALLENGED_NOT_IN_LIST:
                return "" + challenger + " has not challenged you. You must challenge them instead.";
            default:
                return "Unknown error";
        }
    }

    @RequestMapping(value="/{username}/{password}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("username") String username,
                         @PathVariable("password") String password) {
        User deleted = userService.getUser(username, password);
        // If the username and password match, delete the user
        if(deleted != null) {
            
            userService.deleteUser(deleted);
            return "The user " + username + " has been deleted.";
        }
        return "The given username and password do not match.";
    }

    @RequestMapping(value="/{username}/{password}/update/{newPassword}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("username") String username,
                             @PathVariable("password") String password,
                             @PathVariable("newPassword") String newPass) {
        User user = userService.getUser(username, password);
        // If the username and password match, update the user's password
        if(user != null) {
                                    
            userService.updateUser(user, newPass);
            return username + "'s has been updated.";
        }
        return "The given username and password do not match.";
    }
}
