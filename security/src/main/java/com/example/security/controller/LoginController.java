package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

//    @PostMapping("/login")
//    public String login() {
//        System.out.println("请求了自定义login接口");
//        return "redirect: main.html";
//    }

    @PostMapping("/toMain")
    public String main() {
        System.out.println("请求了自定义main接口");
        return "redirect:main.html";
    }


    @PostMapping("/toError")
    public String error() {
        System.out.println("请求了自定义error接口");
        return "redirect:error.html";
    }
}
