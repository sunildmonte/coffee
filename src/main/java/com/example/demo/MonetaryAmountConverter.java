package com.example.demo;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import jakarta.persistence.AttributeConverter;

public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {
    
    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount attribute) {
        BigDecimal bigDecimal = attribute == null ? null : attribute.getNumber().numberValue(BigDecimal.class);
        return bigDecimal;
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal dbData) {
        MonetaryAmount monetaryAmountRD = dbData == null ? null : Money.of(dbData, "INR");
//        if (true) throw new RuntimeException("asdfasdfasfasfsadf");
        return monetaryAmountRD;
    }

}
