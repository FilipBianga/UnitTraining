package com.example.unittraining.section_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

class OrderStatusTest {

    @DisplayName("Testy parametryzowane")
    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldBeShorterThan15Chars(OrderStatus orderStatus) {
        assertThat(orderStatus.toString().length(), lessThan(10));
    }

}