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
}
