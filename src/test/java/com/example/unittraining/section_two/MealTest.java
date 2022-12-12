package com.example.unittraining.section_two;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void referenceToTheSameObjectShouldBeEqual() {

        //given
        Meal meal1 = new Meal(100);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);
    }

    @Test
    void referenceToDifferentObjectShouldBeNotEqual() {

        //given
        Meal meal1 = new Meal(100);
        Meal meal2 = new Meal(10);

        //then
        assertNotSame(meal1, meal2);
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {

        //given
        Meal meal1 = new Meal(50, "Burger");
        Meal meal2 = new Meal(50, "Burger");

        //then
        // trzbea nadpisać metode equals oraz hashcode by moc porownac wartosci w obiekcie a nie miejsce w pamieci obiektu
        assertEquals(meal1, meal2);
    }
}