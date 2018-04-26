package com.dev.service;

import com.dev.db.entity.Facebook;
import com.dev.db.repository.FacebookRepository;
import com.dev.service.FacebookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImpl implements FacebookService{

    @Autowired
    private FacebookRepository repository;


    public JSONObject findByUserName(String userName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", repository.findByUserName(userName));

        return jsonObject;
    }


    public JSONObject findAll() {
        JSONObject jsonObject = new JSONObject();
        for (Facebook fb: repository.findAll()){
            jsonObject.put(fb.getId(), fb);
        }
        return jsonObject;
    }
}
