package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Sql("/inserts.sql")
class CoffeeApplicationTests {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Test
    void mathOperator() {
        List<Coffee> list = coffeeRepository.mathOperator();
        log.debug("list: {}", list);
    }

    @Test
    void nativeQuery() {
        List<Object[]> list = coffeeRepository.nativeQuery();
        MonetaryAmount amount = Money.of((BigDecimal) list.get(0)[0], "INR");
        log.debug("amount: {}", amount);
    }

    @Test
    void monetaryAmountResult() {
        MonetaryAmount amount = coffeeRepository.monetaryAmountResult();
        log.debug("amount: {}", amount);
    }

    @Test
    void bigDecimalResultNative() {
        BigDecimal amount = coffeeRepository.bigDecimalResultNative();
        log.debug("amount: {}", amount);
//        log.debug("amount: {}", amount.getNumber().numberValue(BigDecimal.class));
    }
    
//	@Test
//	void converterAndTwoTerms() {
//	    List<Coffee> list = coffeeRepository.converterAndTwoTerms();
//	    log.debug("list: {}", list);
//	}
//	
//    @Test
//    void customTypeAndSingleTerm() {
//        List<Coffee> list = coffeeRepository.customTypeAndSingleTerm();
//        log.debug("list: {}", list);
//	}
//	
//    @Test
//    void customTypeAndTwoTerms() {
//        List<Coffee> list = coffeeRepository.customTypeAndTwoTerms();
//        log.debug("list: {}", list);
//    }
//    
//    @Test
//    void bigDecimals() {
//        List<Coffee> list = coffeeRepository.bigDecimalsSingleTerm();
//        log.debug("list: {}", list);
//    }
    

}
