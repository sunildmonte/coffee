package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import javax.money.MonetaryAmount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query(value = "SELECT c FROM Coffee c where c.price + c.maxPrice >= 1 ")
    List<Coffee> mathOperator();

    @Query(value = "SELECT c.price FROM Coffee c where c.id = 1 ")
    MonetaryAmount monetaryAmountResult();
    
    @Query(value = "SELECT c.price FROM Coffee c where c.id = 1 ", nativeQuery = true)
    BigDecimal bigDecimalResultNative();
    
    @Query(value = "SELECT c.price + c.max_price FROM Coffee c where c.price + c.max_price >= 1 ", nativeQuery = true)
    List<Object[]> nativeQuery();
    
//    @Query(value = "SELECT c FROM Coffee c where c.price / c.maxPrice <= 1 * 1")
//    List<Coffee> converterAndTwoTerms();
//    
//    @Query(value = "SELECT c FROM Coffee c where c.custom1 / c.custom2 <= 1 ")
//    List<Coffee> customTypeAndSingleTerm();
//    
//    @Query(value = "SELECT c FROM Coffee c where c.custom1 / c.custom2 <= 1 * 1")
//    List<Coffee> customTypeAndTwoTerms();
//    
//    @Query(value = "SELECT c FROM Coffee c where c.bd1 / c.bd2 <= 1 ")
//    List<Coffee> bigDecimalsSingleTerm();
    
    
    
    
    
    
    
    
    
    
}


























