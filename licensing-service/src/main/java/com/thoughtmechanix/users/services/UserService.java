package com.thoughtmechanix.users.services;

import com.thoughtmechanix.users.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    public User getUser(String userId){
        return new User()
                .withId(userId)
                .withOrganizationId( UUID.randomUUID().toString() )
                .withProductName("Test Product Name")
                .withUserType("PerSeat");
    }

    public void saveUser(User user){

    }

    public void updateUser(User user){

    }

    public void deleteUser(User user){

    }

}
