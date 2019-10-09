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
@RabbitListener(queues = "topic.messages")
public class TopicReceiverTwo {

    /**
     *  接受消息
     * @param message
     */
    @RabbitHandler
    public void receiver(String message) {
        System.out.println("topic receiveTwo:" + message);
    }
}
