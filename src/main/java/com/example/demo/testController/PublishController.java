package com.example.demo.testController;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: elvin
 */
//@RestController
//@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/queue")
    public String queue(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend(queue, "queue"+i);
        }

        return "queue 发送成功";
    }

    @JmsListener(destination = "publish.queue", containerFactory="jmsListenerContainerQueue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }
    
    @JmsListener(destination = "publish.queue", containerFactory="jmsListenerContainerQueue")
    public void consumerMsg2(String msg){
        System.out.println("que=="+msg);
    }
    
    @JmsListener(destination = "publish.topic", containerFactory="jmsListenerContainerTopic")
    public void consumerTopicMsg(String msg){
        System.out.println(msg);
    }
    
    @JmsListener(destination = "publish.topic", containerFactory="jmsListenerContainerTopic")
    public void consumerTopicMsg2(String msg){
        System.out.println("=="+msg);
    }

    @RequestMapping("/topic")
    public String topic(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend(topic, "topic"+i);
        }

        return "topic 发送成功";
    }
}
