package com.dev.controller;

import com.dev.proxy.FacebookServiceProxy;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class HealthStatusController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FacebookServiceProxy proxy;


    @GetMapping("/health-status/username/{username}")
    public JSONObject healthStatusCheck(@PathVariable(value = "username") String username) {

        JSONObject response = proxy.retrieveUserStatus(username);

        logger.info("{}", response);

        return response;
    }

}
