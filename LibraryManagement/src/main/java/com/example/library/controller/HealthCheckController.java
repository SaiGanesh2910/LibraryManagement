package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping({"HealthCheck","healthCheck","healthcheck"})
    @ResponseBody
    public String getString(){
        return "Service is Up";
    }
}
