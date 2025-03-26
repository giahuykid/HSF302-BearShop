package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Users;
import com.hsf302.shopbear.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthIMPL implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users authenticate(String username, String password) {
        Users user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
