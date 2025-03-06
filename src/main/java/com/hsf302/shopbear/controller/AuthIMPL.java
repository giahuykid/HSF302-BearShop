package com.hsf302.shopbear.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AuthIMPL {

    @GetMapping("/home")
    public ModelAndView showStudent(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("homejsp");
        return modelAndView;
    }

}
