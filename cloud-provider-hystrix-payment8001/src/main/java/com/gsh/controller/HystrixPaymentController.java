package com.gsh.controller;

import com.gsh.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixPaymentController {
    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String visit_ok(@PathVariable("id") Integer id){
        return hystrixService.visit_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout")
    public String visit_timeout() throws InterruptedException {
        return hystrixService.visit_timeout();
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBeaker(@PathVariable("id")Integer id){
        String result = hystrixService.paymentCircuitBreaker(id);
        log.info("---RESULT----"+result);
        return result;
    }
}
