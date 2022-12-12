package com.example.unittraining.section_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNtoBeActiveAfterCreation() {
        //given
        Account account = new Account();

        //then
        assertFalse(account.isActive());

    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        //given
        Account account = new Account();

        //when
        account.activate();

        //then
        assertTrue(account.isActive());
    }

}