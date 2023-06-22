package com.example.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/about-us")
    public String about() {
        return "about";
    }
}
