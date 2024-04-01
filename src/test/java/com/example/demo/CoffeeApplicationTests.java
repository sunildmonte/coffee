package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class CoffeeApplicationTests {

    @Autowired
    private CoffeeRepository coffeeRepository;
    
	@Test
	void converterAndSingleTerm() {
	    List<Coffee> list = coffeeRepository.converterAndSingleTerm();
	    log.debug("list: {}", list);
	}
	
	@Test
	void converterAndTwoTerms() {
	    List<Coffee> list = coffeeRepository.converterAndTwoTerms();
	    log.debug("list: {}", list);
	}
	
    @Test
    void customTypeAndSingleTerm() {
        List<Coffee> list = coffeeRepository.customTypeAndSingleTerm();
        log.debug("list: {}", list);
	}
	
    @Test
    void customTypeAndTwoTerms() {
        List<Coffee> list = coffeeRepository.customTypeAndTwoTerms();
        log.debug("list: {}", list);
    }
    
    @Test
    void bigDecimals() {
        List<Coffee> list = coffeeRepository.bigDecimalsSingleTerm();
        log.debug("list: {}", list);
    }
    

}
