package com.example.unittraining.section_one;

import com.example.unittraining.section_third.Address;

public class Account {
    private boolean active;
    private Address defaultDeliveryAddress;

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public Account() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }
}
