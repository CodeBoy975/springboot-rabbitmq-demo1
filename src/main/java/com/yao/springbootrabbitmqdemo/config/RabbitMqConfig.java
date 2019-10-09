package com.yao.springbootrabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 描述： 队列配置，队列的名称，发送者和接受者的名称必须一致，否则收不到消息
 * @author pengjie_yao
 * @date 2019/10/911:18
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("queueOne");
    }

    @Bean
    public Queue queueTwo() {
        return new Queue("queueTwo");
    }

}
