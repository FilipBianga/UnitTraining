package com.example.unittraining.section_two;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Meal {

    private int price;
    private String name;

    public Meal(int price) {
        this.price = price;
    }

    public int getDiscountedPrice(int discount) {
        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price && Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
