package com.example.unittraining.section_one;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
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

    @Tag("burger")
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

    @DisplayName("Testy parametryzowane")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 19})
    void mealPriceShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @DisplayName("Testy parametryzowane")
    @Tag("burger")
    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgerShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Chesseburger", 12)
        );
    }

    @DisplayName("Testy parametryzowane")
    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> cakeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return cakeNames.stream();
    }

    @DisplayName("Testy dynamiczne")
    @Tag("burger")
    @TestFactory
    Collection<DynamicTest> calculateMealPrices() {
        Order order = new Order();
        order.addMealToOrder(new Meal(10, 2, "Hamburger"));
        order.addMealToOrder(new Meal(7, 4, "Fries"));
        order.addMealToOrder(new Meal(22, 3, "Pizza"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i = 0; i < order.getMeals().size(); i++) {

            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(i).getQuantity();

            Executable executable = () -> {
                assertThat(calculatePrice(price, quantity), lessThan(67));
            };

            String name = "Test name: " + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests;
    }

    private int calculatePrice(int price, int quantity) {
        return price * quantity;
    }
}