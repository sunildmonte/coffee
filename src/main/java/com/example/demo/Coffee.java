package com.example.demo;

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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Convert(converter = MyMonetaryAmountConverter.class)
    @Column(name = "price")
    private MyMonetaryAmount price;

    @Convert(converter = MyMonetaryAmountConverter.class)
    @Column(name = "max_price")
    private MyMonetaryAmount maxPrice;

}
