package org.codedesigner.micronaut;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class ChannelPoolListener extends ChannelInitializer {

    @Override
    public void initialize(Channel channel) throws IOException {
        channel.exchangeDeclare("micronaut", BuiltinExchangeType.DIRECT, true); // <1>

        channel.queueDeclare("events", true, false, false, null); // <2>
        channel.queueBind("events", "micronaut", "event.message"); // <3>
    }
}
