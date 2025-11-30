package com.ricardo.hexagonal_architecture.adapters.out;

import com.ricardo.hexagonal_architecture.adapters.out.repositories.CustomerRepository;
import com.ricardo.hexagonal_architecture.adapters.out.repositories.entities.CustomerEntity;
import com.ricardo.hexagonal_architecture.adapters.out.repositories.mapper.CustomerEntityMapper;
import com.ricardo.hexagonal_architecture.application.core.domain.Customer;
import com.ricardo.hexagonal_architecture.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public CustomerEntity update(Customer customer) {
        var result = customerEntityMapper.toCustomerEntity(customer);
        return customerRepository.save(result);
    }
}
