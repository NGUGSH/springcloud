package com.gsh.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements HystrixOrderService {

    @Override
    public String visit_ok(Integer id) {
        return "PaymentFallbackService ----  visit_ok -----  异常处理";
    }

    @Override
    public String visit_timeout() throws InterruptedException {
        return "PaymentFallbackService ----  visit_timeout -----  异常处理";
    }
}
