package com.example.demo;

import java.math.BigDecimal;

import jakarta.persistence.AttributeConverter;

public class MyMonetaryAmountConverter implements AttributeConverter<MyMonetaryAmount, BigDecimal> {
    
    @Override
    public BigDecimal convertToDatabaseColumn(MyMonetaryAmount attribute) {
        BigDecimal bigDecimal = attribute == null ? null : attribute.getAmount();
        return bigDecimal;
    }

    @Override
    public MyMonetaryAmount convertToEntityAttribute(BigDecimal dbData) {
        MyMonetaryAmount monetaryAmountRD = dbData == null ? null : MyMonetaryAmount.of(dbData);
        return monetaryAmountRD;
    }

}
