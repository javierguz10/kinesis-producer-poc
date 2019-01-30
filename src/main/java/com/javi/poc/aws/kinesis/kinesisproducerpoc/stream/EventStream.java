package com.javi.poc.aws.kinesis.kinesisproducerpoc.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

public interface EventStream {
    @Output(OUTPUT)
    MessageChannel outputStream();
}