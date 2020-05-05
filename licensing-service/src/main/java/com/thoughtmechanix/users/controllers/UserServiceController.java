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
@RequestMapping(value="v1/organizations/{organizationId}/users")
public class UserServiceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    public User getUsers( @PathVariable("organizationId") String organizationId,
                                @PathVariable("userId") String userId) {

        //return userService.getUser(userId);
        return new User()
            .withId(userId)
            .withOrganizationId(organizationId)
            .withProductName("Teleco")
            .withUserType("Seat");
    }

    @RequestMapping(value="/{userId}",method = RequestMethod.PUT)
    public String updateUsers( @PathVariable("userId") String userId) {
        return String.format("This is the put");
    }

    @RequestMapping(value="/{userId}",method = RequestMethod.POST)
    public String saveUsers( @PathVariable("userId") String userId) {
        return String.format("This is the post");
    }

    @RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUsers( @PathVariable("userId") String userId) {
        return String.format("This is the Delete");
    }
}
