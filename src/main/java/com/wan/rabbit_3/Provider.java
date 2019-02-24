package com.wan.rabbit_3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @Author 万星明
 * @Date 2019/2/24
 */
@Component
public class Provider {

    @Autowired
    private  AmqpTemplate amqpTemplate;

    public void test(){
        String str = "测试RabbitMQ模式3";
        try {
            amqpTemplate.convertAndSend("text_exchange","",  str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
