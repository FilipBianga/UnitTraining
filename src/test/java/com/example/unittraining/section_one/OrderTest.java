package com.example.unittraining.section_one;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {
        //given
        int[] tab1 = {1, 3, 5};
        int[] tab2 = {1, 3, 5};

        //then
        assertArrayEquals(tab1, tab2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {

        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Tag("burger")
    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        //given
        Meal meal = new Meal(20, "Hamburger");
        Meal meal2 = new Meal(35, "Pizza");

        //when
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal2));

        assertThat(order.getMeals().get(0).getPrice(), equalTo(35));
    }

    @Tag("burger")
    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {
        //given
        Meal meal = new Meal(20, "Hamburger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        //given
        Meal meal = new Meal(20, "Hamburger");
        Meal meal2 = new Meal(35, "Pizza");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal));

    }

}