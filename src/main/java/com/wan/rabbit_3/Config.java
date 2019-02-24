package com.wan.rabbit_3;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 万星明
 * @Date 2019/2/24
 */

@Configuration
public class Config {


    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue getQueue(){
        Queue queue = new Queue("text_queue");
        return queue;
    }


    /**
     * 声明交换机
     * @return
     */
    @Bean
    public FanoutExchange getExchange(){
        return new FanoutExchange("text_exchange");


    }

    /**
     * 绑定交换机和队列
     * @param getQueue
     * @param getExchange
     * @return
     */
    @Bean
    public Binding getExchangeBinding(Queue getQueue, FanoutExchange getExchange){
        return BindingBuilder.bind(getQueue).to(getExchange);
    }

}
