package com.pcg.gitdemo.controllers;

import com.pcg.gitdemo.services.UserService;
import com.pcg.gitdemo.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    
    @Autowired
    private UserService service;

    @RequestMapping("/user")
    public String viewAssets(Model model){
        Iterable<User> users = service.listAll();
        model.addAttribute("listUsers", users);
        return "userHome";
    }
}
