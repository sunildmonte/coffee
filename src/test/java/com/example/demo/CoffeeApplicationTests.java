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
	void test1() {
	    List<Coffee> list = coffeeRepository.query1();
	    log.debug("list: {}", list);
	}
	
	@Test
	void test2() {
	    List<Coffee> list = coffeeRepository.query2();
	    log.debug("list: {}", list);
	}
	

}
