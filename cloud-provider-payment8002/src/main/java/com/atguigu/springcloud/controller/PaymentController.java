package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2020/5/19 15:04
 **/
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    private Logger logger=LoggerFactory.getLogger(PaymentController.class);


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment, HttpServletRequest request){

        int result = paymentService.create(payment);
        logger.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,port:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败,port:"+serverPort, null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment=paymentService.getPaymentById(id);
        if(payment!=null){
            return  new CommonResult(200,"查询成功,port:"+serverPort,payment);

        }else{
            return  new CommonResult(444,"查询失败，id="+id+"port:"+serverPort,null);
        }
    }
}
