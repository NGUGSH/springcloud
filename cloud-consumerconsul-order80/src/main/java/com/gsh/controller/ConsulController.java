package com.gsh.controller;

import com.gsh.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsulController {
    private static final String url = "http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consume/payment/consul")
    public String   getConsul(){
        return restTemplate.getForObject(url+"/payment/consul", String.class);
    }
}
