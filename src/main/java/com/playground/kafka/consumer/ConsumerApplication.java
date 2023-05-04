package com.playground.kafka.consumer;

import com.playground.kafka.consumer.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@Slf4j
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@KafkaListener(topics = "transaction-1")
	public void listener(@Payload Account account, ConsumerRecord<String, Account> consumerRecord){
		log.info("Topic [transaction-1] Received message from {} with {} PLN", account.getHolder(), account.getFunds());
		log.info(consumerRecord.toString());
	}

}
