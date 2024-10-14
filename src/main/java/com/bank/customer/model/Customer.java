package com.bank.customer.model;

import java.util.List;
import java.util.UUID;

public class Customer {
    private String uuid;
    private String name;
    private String surname;

    public Customer() {
    }

    public Customer( String name, String surname) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
