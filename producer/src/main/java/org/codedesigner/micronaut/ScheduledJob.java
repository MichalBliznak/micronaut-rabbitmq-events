package org.codedesigner.micronaut;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Singleton
public class ScheduledJob {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Inject
    EventProducer eventProducer;

    @Scheduled(fixedRate = "5s")
    public void process() {
        logger.info("Sending message...");
        eventProducer.send("Hello World!");
    }
}