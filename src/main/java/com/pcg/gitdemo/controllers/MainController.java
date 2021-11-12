package com.pcg.gitdemo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String viewIndexPage(Model model){
        model.addAttribute("header", "Maven generate war");
        return "index";
    }
}
