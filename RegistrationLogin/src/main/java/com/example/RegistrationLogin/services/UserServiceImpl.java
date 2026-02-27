package com.example.RegistrationLogin.services;

import com.example.RegistrationLogin.entities.User;
import com.example.RegistrationLogin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    private  UserRepository userRepository;


    @Override
    public boolean registerUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
