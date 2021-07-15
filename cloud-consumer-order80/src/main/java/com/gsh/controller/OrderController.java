package com.gsh.controller;

import com.gsh.entities.CommonResult;
import com.gsh.entities.Payment;
import com.gsh.mylb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
//    private static final String providerUrl = "http://localhost:8001";

    private static final String providerUrl = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(providerUrl+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/select/{id}")
    public CommonResult select(@PathVariable("id") long id){
        return restTemplate.getForObject(providerUrl+"/payment/select/"+id,CommonResult.class);
    }

    @GetMapping("/selectForEntity/{id}")
    public CommonResult select2(@PathVariable("id") long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(providerUrl + "/payment/select/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(500,"查询失败");
        }
    }

    @GetMapping("/select2/{id}")
    public CommonResult select3(@PathVariable("id") long id){
        List<ServiceInstance> instances1 = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances1==null || instances1.size()<=0){
            return null;
        }
        ServiceInstance instances = loadBalancer.instances(instances1);

        return restTemplate.getForObject(instances.getUri()+"/payment/select/"+id,CommonResult.class);
    }
}
