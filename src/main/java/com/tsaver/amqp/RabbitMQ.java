package com.tsaver.amqp;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class RabbitMQ {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveTweetMessage(String message){
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
