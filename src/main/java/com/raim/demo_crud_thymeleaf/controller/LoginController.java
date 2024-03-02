package com.raim.demo_crud_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "fancy-login";
    }
//    @GetMapping("/leaders")
//    public String showLeaders(){
//        return "leaders";
//    }
//    @GetMapping("/systems")
//    public String showSystems(){
//        return "systems";
//    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied_Page";
    }
    @GetMapping("/logout")
    public String showLogoutPage(){
        return "fancy-login";
    }
}
