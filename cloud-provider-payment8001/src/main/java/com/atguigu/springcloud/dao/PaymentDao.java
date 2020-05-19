package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2020/5/19 14:51
 **/
@Mapper
public interface PaymentDao {

    public  int create(Payment payment);

    public  Payment getPaymentById(@Param("id")Long id);
}
