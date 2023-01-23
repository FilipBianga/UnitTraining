package com.example.unittraining.section_one;

import com.example.unittraining.section_third.Address;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNtoBeActiveAfterCreation() {
        //given
        Account account = new Account();

        //then
        assertFalse(account.isActive());

        //matchers
        assertThat(account.isActive(), equalTo(false));
        assertThat(account.isActive(), is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        //given
        Account account = new Account();

        //when
        account.activate();

        //then
        assertTrue(account.isActive());

        //matchers
        assertThat(account.isActive(), equalTo(true));
        assertThat(account.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);

        //matchers
        assertThat(address, nullValue());

    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Kartuska", "198");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);

        //matcher
        assertThat(defaultAddress, notNullValue());
    }

}