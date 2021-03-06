package com.hella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auth hywang
 * @Email hywang2017@qq.com
 * @Date 2018/3/3
 */
@RestController
public class ProducerContorller {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Value("${queue}")
    private String queue;

    @RequestMapping(value = "/sendMessage/{data}")
    public String sendMessage(@PathVariable("data") String data) {
        jmsMessagingTemplate.convertAndSend(queue, data);
        return "succ";
    }
}
