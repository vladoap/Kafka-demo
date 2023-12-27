package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.CarPartDto;

public interface PublicationService {

    void publishCarPart(CarPartDto carPart);
}
