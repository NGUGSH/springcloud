package com.gsh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface HystrixOrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String visit_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout")
    public String visit_timeout() throws InterruptedException;
}
