package com.example.unittraining.section_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @DisplayName("Testy parametryzowane")
    @ParameterizedTest
    @CsvSource({"Kartuska, 100", "Grunwaldzka, 109/11"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }

    @DisplayName("Testy parametryzowane")
    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }

}