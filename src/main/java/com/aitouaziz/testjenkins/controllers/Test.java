package com.aitouaziz.testjenkins.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class Test {

    @GetMapping(path = "/hello")
    public @ResponseBody String hello(@RequestParam String name)
    {
        return "Hello " + name;
    }
}