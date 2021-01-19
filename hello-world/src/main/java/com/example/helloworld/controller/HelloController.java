package com.example.helloworld.controller;

import com.example.helloworld.config.Amazon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private Amazon amazon;

    @GetMapping("test")
    public Amazon test() {
        return amazon;
    }
}
