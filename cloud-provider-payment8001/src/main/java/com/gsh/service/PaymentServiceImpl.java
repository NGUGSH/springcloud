package com.gsh.service;

import com.gsh.dao.PaymentMapper;
import com.gsh.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public int create(Payment payment) {
        int i = paymentMapper.create(payment);
        return i;
    }

    @Override
    public List<Payment> select(Long id) {
       return paymentMapper.select(id);
    }
}
