package com.ricardo.hexagonal_architecture.adapters.out.repositories.entities;

import lombok.Data;

@Data
public class AddressEntity {

    private String street;
    private String city;
    private String state;
}
