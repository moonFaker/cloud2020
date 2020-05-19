package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2020/5/19 15:01
 **/
public interface PaymentService {

    public  int create(Payment payment);

    public  Payment getPaymentById(Long id);
}
