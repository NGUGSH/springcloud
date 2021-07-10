package com.gsh.controller;

import com.gsh.entities.CommonResult;
import com.gsh.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
    private static final String providerUrl = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(providerUrl+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/select/{id}")
    public CommonResult select(@PathVariable("id") long id){
        return restTemplate.getForObject(providerUrl+"/payment/select/"+id,CommonResult.class);
    }
}
