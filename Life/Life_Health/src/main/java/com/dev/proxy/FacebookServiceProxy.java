package com.dev.proxy;

import org.json.simple.JSONObject;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="life-service", url="localhost:8000")//without ribbon
//@FeignClient(name="life-service")//without eureka server
//@RibbonClient(name="life-service")//without eureka server
@FeignClient(name="LIFE-SOCIAL")
@RibbonClient(name="LIFE-SOCIAL")
public interface FacebookServiceProxy {
    @GetMapping("/api/facebook/username/{username}")
    public JSONObject retrieveUserStatus
            (@PathVariable("username") String username);
}
