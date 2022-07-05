package com.lty.threadpool.sys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Tianyu
 * @date 2022/6/2 15:39
 */
@RestController
@RequestMapping("/send")
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "test message, hello!";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String,Object> map=new HashMap<>();
            map.put("messageId",messageId);
            map.put("messageData",messageData);
            map.put("createTime",createTime);
            Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(map)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
            rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",message);
        }catch (Exception e){
            e.printStackTrace();

        }

        return "ok";
    }

    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "message: woman is all ";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> womanMap = new HashMap<>();
            womanMap.put("messageId", messageId);
            womanMap.put("messageData", messageData);
            womanMap.put("createTime", createTime);
            Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(womanMap)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
            rabbitTemplate.convertAndSend("topicExchange", "topic.woman", message);
        }catch (Exception e){
        }
        return "ok";
    }


}
