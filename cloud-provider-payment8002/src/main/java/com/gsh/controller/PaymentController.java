package com.gsh.controller;

import com.gsh.entities.CommonResult;
import com.gsh.entities.Payment;
import com.gsh.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("开始插入数据，入参为"+payment.toString()+"123465789sadas");
        if(result>0){
            return new CommonResult(200,"插入数据成功,serverPort: "+serverPort,result);
        }else{
            return new CommonResult(500,"插入数据失败,serverPort: "+serverPort,null);
        }
    }

    @GetMapping("/select/{id}")
    public CommonResult select(@PathVariable("id") Long id){
        List<Payment> payment = paymentService.select(id);
        log.info("开始查询数据，id为"+id);
        if(payment!=null){
            return new CommonResult(200,"查询数据成功,serverPort: "+serverPort,payment);
        }else {
            return new CommonResult(500,"查询数据不存在，id为"+id,null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: "+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance: "+instance+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/timeout")
    public String getPort(){
        return serverPort;
    }

}
