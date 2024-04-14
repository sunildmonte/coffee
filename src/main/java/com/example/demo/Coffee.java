package com.example.demo;

import java.math.BigDecimal;
import java.sql.Types;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.JavaType;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.descriptor.jdbc.NumericJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "coffee")
@Getter
@Setter
@Slf4j
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    
    @Convert(converter = MonetaryAmountConverter.class)
    @Column(name = "price")
    private MonetaryAmount price;

    @Convert(converter = MonetaryAmountConverter.class)
    @Column(name = "max_price")
    private MonetaryAmount maxPrice;


//    @JavaType(MyMoneyJavaType.class)
////    @JdbcType(NumericJdbcType.class)
//    private MyMonetaryAmount custom1;
//
//    @JavaType(MyMoneyJavaType.class)
////    @JdbcType(NumericJdbcType.class)
//    private MyMonetaryAmount custom2;
//    
//
//    @Column(name = "bd1")
//    private BigDecimal bd1;
//
//    @Column(name = "bd2")
//    private BigDecimal bd2;
//
    @Override
    public String toString() {
        return price.toString();
    }
}
