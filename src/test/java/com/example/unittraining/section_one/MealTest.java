package com.example.unittraining.section_one;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountPrice() {

        //given
        Meal meal = new Meal(50);

        //when
        int discountedPrice = meal.getDiscountedPrice(10);

        //then
        assertEquals(40, discountedPrice);

        //assertJ
        assertThat(discountedPrice).isEqualTo(40);
    }

    @Test
    void referenceToTheSameObjectShouldBeEqual() {

        //given
        Meal meal1 = new Meal(100);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);

        //assertJ
        assertThat(meal1).isSameAs(meal2);
    }

    @Test
    void referenceToDifferentObjectShouldBeNotEqual() {

        //given
        Meal meal1 = new Meal(100);
        Meal meal2 = new Meal(10);

        //then
        assertNotSame(meal1, meal2);

        //assertJ
        assertThat(meal1).isNotSameAs(meal2);
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {

        //given
        Meal meal1 = new Meal(50, "Burger");
        Meal meal2 = new Meal(50, "Burger");

        //then
        assertEquals(meal1, meal2);
    }

    // Testowanie wyjątku
    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {

        //given
        Meal meal = new Meal(10, "Sajgonki");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(20));
    }
}