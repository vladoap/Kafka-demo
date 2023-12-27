package com.example.kafkaconsumer.consumer;

import com.example.kafkaproducer.model.CarPartDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class CarPartsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarPartsConsumer.class);


    @KafkaListener(
            containerFactory = "kafkaContainerFactory",
            topics = "car_parts",
            groupId = "my-consumer"
    )
    public void readMessage(@Header(KafkaHeaders.RECEIVED_KEY) String key, CarPartDto carPart) {


        LOGGER.info("Message consumed with key {} and value {}",
                key,
                carPart);
    }
}
