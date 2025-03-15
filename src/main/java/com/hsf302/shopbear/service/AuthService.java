package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    Users authenticate(String username, String password);
    Users findByUsername(String username);
}
