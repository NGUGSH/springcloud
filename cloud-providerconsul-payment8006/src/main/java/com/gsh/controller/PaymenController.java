package com.gsh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymenController {

    @RequestMapping("/payment/consul")
    public String getConsul(){
        return "consule: "+"\t"+ UUID.randomUUID();
    }
}
