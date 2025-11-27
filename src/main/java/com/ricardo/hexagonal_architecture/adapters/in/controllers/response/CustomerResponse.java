package com.ricardo.hexagonal_architecture.adapters.in.controllers.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;
}
