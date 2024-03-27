package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query(value = "SELECT c FROM Coffee c where c.price / c.maxPrice <= 1")
    List<Coffee> query1();

    @Query(value = "SELECT c FROM Coffee c where c.price <= 1 * c.maxPrice")
    List<Coffee> query2();
    
    
}


























