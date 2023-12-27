package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.model.CarPartDto;
import com.example.kafkaproducer.service.PublicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.kafkaproducer.config.KafkaConfiguration.CAR_PART_TOPIC;


@Service
public class PublicationServiceImpl implements PublicationService {

    private final Logger LOGGER = LoggerFactory.getLogger(PublicationService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PublicationServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishCarPart(CarPartDto carPartDto) {
        kafkaTemplate
                .send(CAR_PART_TOPIC, UUID.randomUUID().toString(), carPartDto)
                .whenComplete((res, ex) -> {
                    if (ex == null) {
                        LOGGER.info(
                                "Successfully sent to topic {}/ partition {}/ offset {}/ key {}",
                                res.getRecordMetadata().topic(),
                                res.getRecordMetadata().partition(),
                                res.getRecordMetadata().offset(),
                                res.getProducerRecord().key()
                        );
                    } else {
                        LOGGER.error("Problem publishing to kafka.");
                    }
                });
    }
}
