package com.example.PP_311_SpringBoot.controller;

import com.example.PP_311_SpringBoot.model.User;
import com.example.PP_311_SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUser(Principal principal, ModelMap modelMap) {
        User userBd = userService.getByName(principal.getName());
        modelMap.addAttribute("user", userBd);
        return "user";
    }


}