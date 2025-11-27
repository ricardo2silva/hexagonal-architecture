package com.ricardo.hexagonal_architecture.adapters.out.repositories.mapper;

import com.ricardo.hexagonal_architecture.adapters.out.repositories.entities.CustomerEntity;
import com.ricardo.hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
