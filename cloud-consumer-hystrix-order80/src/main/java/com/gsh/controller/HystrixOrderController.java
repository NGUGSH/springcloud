package com.gsh.controller;

import com.gsh.service.HystrixOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "global_fallback",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
})
public class HystrixOrderController {

    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String visit_ok(@PathVariable("id") Integer id){
        return hystrixOrderService.visit_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout")
    /*@HystrixCommand(fallbackMethod = "timeout_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String visit_timeout() throws InterruptedException{
        return hystrixOrderService.visit_timeout();
    }
    public String global_fallback(){
        return "全局配置的fallback，服务响应失败，请稍后再试";
    }

    public String timeout_fallback(){
        return "这是客户端80----，服务响应失败，请稍后再试";
    }
}
