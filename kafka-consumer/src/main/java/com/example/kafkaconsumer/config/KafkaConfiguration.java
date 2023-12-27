package com.example.kafkaconsumer.config;

import com.example.kafkaproducer.model.CarPartDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, CarPartDto> consumerFactory(KafkaProperties kafkaProperties) {

        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(null));
    }

//    @Bean
//    public ConsumerFactory<String, CarPartDto> consumerFactory(KafkaProperties kafkaProperties) {
//        kafkaProperties.getProperties().put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        kafkaProperties.getProperties().put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class.getName());
//
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties(null),
//                new StringDeserializer(),
//                new ErrorHandlingDeserializer<>(new JsonDeserializer<>(CarPartDto.class))
//        );
//    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarPartDto> kafkaContainerFactory(
            ConsumerFactory<String, CarPartDto> consumerFactory) {

        ConcurrentKafkaListenerContainerFactory<String, CarPartDto> containerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        containerFactory.setConsumerFactory(consumerFactory);
        return containerFactory;
    }
}
