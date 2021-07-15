package com.gsh.dao;

import com.gsh.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    public int create(Payment payment);

    public List<Payment> select(@Param("id") Long id);
}
