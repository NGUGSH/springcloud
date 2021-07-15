package com.gsh.controller;

import com.gsh.entities.CommonResult;
import com.gsh.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {
    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/select/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        return openFeignService.select(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        return openFeignService.FeignTimeout();
    }
}
