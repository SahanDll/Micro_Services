package com.dev.controller;

import com.dev.service.FacebookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FacebookController {

    @Autowired
    private Environment environment;

    @Autowired
    private FacebookService facebookService;

    @GetMapping("/facebook/username/{username}")
    public JSONObject findByUserName
            (@PathVariable(value = "username") String username){

        return facebookService.findByUserName(username);
    }

    @RequestMapping(value = "/facebook/all", method = RequestMethod.GET)
    public JSONObject findAll(){

        return facebookService.findAll();
    }
}
