package com.yao.springbootrabbitmqdemo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受信息
 *
 * @author pengjie_yao
 * @date 2019/10/911:25
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    /**
     *  接受消息
     * @param message
     */
    @RabbitHandler
    public void receiver(String message) {
        System.out.println("topic receiveOne:" + message);
    }
}
