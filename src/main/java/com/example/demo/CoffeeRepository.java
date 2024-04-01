package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query(value = "SELECT c FROM Coffee c where c.price / c.maxPrice <= 1 ")
    List<Coffee> converterAndSingleTerm();

    @Query(value = "SELECT c FROM Coffee c where c.price / c.maxPrice <= 1 * 1")
    List<Coffee> converterAndTwoTerms();
    
    @Query(value = "SELECT c FROM Coffee c where c.custom1 / c.custom2 <= 1 ")
    List<Coffee> customTypeAndSingleTerm();
    
    @Query(value = "SELECT c FROM Coffee c where c.custom1 / c.custom2 <= 1 * 1")
    List<Coffee> customTypeAndTwoTerms();
    
    @Query(value = "SELECT c FROM Coffee c where c.bd1 / c.bd2 <= 1 ")
    List<Coffee> bigDecimalsSingleTerm();
    
    
    
    
    
    
    
    
    
    
}


























