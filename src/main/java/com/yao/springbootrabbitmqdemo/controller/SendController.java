package com.yao.springbootrabbitmqdemo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 发送者的controller
 *
 * @author pengjie_yao
 * @date 2019/10/911:21
 */
@RestController
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @param message
     * @return
     */
    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        for (int i = 0; i < 20; i++) {
            // 往队列名为queueOne中发送消息
            amqpTemplate.convertAndSend("queueOne", "第" + i + "次发送消息为:" + message);
            amqpTemplate.convertAndSend("queueTwo", "第" + i + "次发送消息为:" + message);
        }
        return "您发送的信息为：" + message;
    }


    @GetMapping("/topicSendOne")
    public String topicSendOne() {

        String message = "topicOne";
        System.out.println("发送者为：" + message);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", message);
        return message;
    }

    @GetMapping("topicSendTwo")
    public String topicSendTwo() {
        String message = "topicTwo";
        System.out.println("发送者为：" + message);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", message);
        return message;
    }
}
