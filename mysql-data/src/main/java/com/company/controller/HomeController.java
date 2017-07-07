package com.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by huanbenwang on 2017/7/7.
 */
@RestController
public class HomeController {

    @GetMapping("/hello")
    public Map<String, Object> greeting(){
        return Collections.singletonMap("message", "Hello world!");
    }

}
