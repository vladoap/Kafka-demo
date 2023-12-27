package com.example.kafkaproducer.web;

import com.example.kafkaproducer.model.CarPartDto;
import com.example.kafkaproducer.service.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class PublisherController {

   private final PublicationService publicationService;

    public PublisherController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/publish")
    public ResponseEntity<Map<String, CarPartDto>> publish() {
        var carPart1 = new CarPartDto("1", "timing belt", new BigDecimal("130.50"), LocalDateTime.now());
        var carPart2 = new CarPartDto("7", "oil filter", new BigDecimal("14.76"), LocalDateTime.now());

        publicationService.publishCarPart(carPart1);
        publicationService.publishCarPart(carPart2);


        return ResponseEntity.ok(Map.of("part1", carPart1, "part2", carPart2));
    }
}
