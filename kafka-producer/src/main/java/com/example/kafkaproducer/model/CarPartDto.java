package com.example.kafkaproducer.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarPartDto {

    private String partId;
    private String partName;

    private BigDecimal price;

    private LocalDateTime localDateTime;

    public CarPartDto() {
    }

    public CarPartDto(String partId, String partName, BigDecimal price, LocalDateTime localDateTime) {
        this.partId = partId;
        this.partName = partName;
        this.price = price;
        this.localDateTime = localDateTime;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }
}
