package com.dev.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

public interface FacebookService {
    public JSONObject findByUserName(String userName);

    public JSONObject findAll();


}
