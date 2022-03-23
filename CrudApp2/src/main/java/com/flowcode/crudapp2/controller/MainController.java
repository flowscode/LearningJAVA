package com.flowcode.crudapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomepage(){
        System.out.println("homepage method");
        return "index";
    }
}
