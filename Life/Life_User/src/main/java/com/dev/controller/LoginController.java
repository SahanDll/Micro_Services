package com.dev.controller;

import com.dev.bean.LoginUser;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class LoginController {
    @RequestMapping(value = "login", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody LoginUser loginUser) {
        String data = "client_id=" + "life-app&"+ "grant_type=" + "password&"+ "username=" + loginUser.getUserName() + "&password=" + loginUser.getPassword();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map<String,String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        headers.setAll(map);

        HttpEntity<?> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:8080//auth/realms/SpringBoot/protocol/openid-connect/token", request, String.class);

        System.out.println("Response : " +response.getBody());

        return response;
    }

    @RequestMapping(value = "refresh", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> refresh(@RequestBody LoginUser loginUser) {
        String data = "client_id=" + "life-app&"+ "grant_type=" + "refresh_token&"+ "refresh_token=" + loginUser.getRefreshToken();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map<String,String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        headers.setAll(map);

        HttpEntity<?> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:8080//auth/realms/SpringBoot/protocol/openid-connect/token", request, String.class);

        System.out.println("Response : " +response.getBody());

        return response;
    }
}
