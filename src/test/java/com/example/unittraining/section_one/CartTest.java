package com.example.unittraining.section_one;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void simulateLargeOrder() {

        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }
}