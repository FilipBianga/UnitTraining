package com.example.unittraining.section_one;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

    @Test
    @Disabled
    @DisplayName("Cart is able to process 100 orders in 100ms")
    void simulateLargeOrder() {

        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }

    @Test
    @DisplayName("Matchery do łaczenia asercji")
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {

        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class))),
                hasSize(1)
                )
        );

        assertAll("This is a group assertion",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, emptyCollectionOf(Meal.class));
                }
                );
    }


}