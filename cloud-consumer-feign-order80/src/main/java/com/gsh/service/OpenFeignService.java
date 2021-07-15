package com.gsh.service;

import com.gsh.entities.CommonResult;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="CLOUD-PAYMENT-SERVICE")
@Service
public interface OpenFeignService {
    @GetMapping("/payment/select/{id}")
    public CommonResult select(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String FeignTimeout();
}
