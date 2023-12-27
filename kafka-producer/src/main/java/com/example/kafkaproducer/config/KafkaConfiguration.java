package com.example.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfiguration {

    public static final String CAR_PART_TOPIC = "car_parts";

    @Bean
    public NewTopic carPartTopic() {
        return TopicBuilder
                .name(CAR_PART_TOPIC)
                .partitions(2)
                .compact()
                .build();
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties(null));
    }

    @Bean
    public KafkaTemplate<String, Object> jsonKafkaTemplate(
            ProducerFactory<String, Object> producerFactory ) {
        return new KafkaTemplate<>(producerFactory);
    }
}
