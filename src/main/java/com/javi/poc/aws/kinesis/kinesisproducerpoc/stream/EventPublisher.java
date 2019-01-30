package com.javi.poc.aws.kinesis.kinesisproducerpoc.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class EventPublisher {

    private EventStream eventStream;
    private AtomicInteger count;

    public EventPublisher(EventStream eventStream) {
        this.eventStream = eventStream;
        count = new AtomicInteger(0);
    }

    @Scheduled(fixedRate = 500)
    public void publishMessage() {
        MessageChannel messageChannel = eventStream.outputStream();
        String message = "Message # " + count.addAndGet(1);
        messageChannel.send(new GenericMessage<>(message));
        log.info("Published messaget: {}", message);
    }
}
