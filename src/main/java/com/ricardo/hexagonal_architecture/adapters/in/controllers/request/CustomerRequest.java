package com.ricardo.hexagonal_architecture.adapters.in.controllers.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;

    private String zipcode;
}
