package org.codedesigner.micronaut;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface EventProducer {
    @Binding("event.message")
    void send(String message);
}