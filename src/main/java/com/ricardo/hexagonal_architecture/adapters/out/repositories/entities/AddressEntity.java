package com.ricardo.hexagonal_architecture.adapters.out.repositories.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
public class AddressEntity {

    private String street;
    private String city;
    private String state;
}
