package com.nahush.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String user, String password){
        boolean isValidUser = user.equalsIgnoreCase("Nahush");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUser && isValidPassword;
    }
}
