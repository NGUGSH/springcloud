package com.gsh.controller;

import com.gsh.entities.CommonResult;
import com.gsh.entities.Payment;
import com.gsh.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("开始插入数据，入参为"+payment.toString()+"123465789sadas");
        if(result>0){
            return new CommonResult(200,"插入数据成功",result);
        }else{
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping("/select/{id}")
    public CommonResult select(@PathVariable("id") Long id){
        List<Payment> payment = paymentService.select(id);
        log.info("开始查询数据，id为"+id);
        if(payment!=null){
            return new CommonResult(200,"查询数据成功",payment);
        }else {
            return new CommonResult(500,"查询数据不存在，id为"+id,null);
        }
    }

}
