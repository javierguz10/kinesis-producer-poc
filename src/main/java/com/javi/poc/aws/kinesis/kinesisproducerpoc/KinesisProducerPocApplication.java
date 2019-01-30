package com.javi.poc.aws.kinesis.kinesisproducerpoc;

import com.javi.poc.aws.kinesis.kinesisproducerpoc.stream.EventStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { ElastiCacheAutoConfiguration.class, ContextStackAutoConfiguration.class})
@EnableScheduling
@EnableBinding(EventStream.class)
public class KinesisProducerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisProducerPocApplication.class, args);
	}

}

