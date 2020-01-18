package org.codedesigner.micronaut;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;

@RabbitListener
public class EventListener {
    @Queue("events")
    public void receive(String message) {
        System.out.println("Java received message '" + message + "' from RabbitMQ");
    }

}