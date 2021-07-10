package com.gsh.service;

import com.gsh.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);

    public List<Payment> select(@Param("id") Long id);
}
