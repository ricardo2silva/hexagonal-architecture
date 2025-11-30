package com.ricardo.hexagonal_architecture.adapters.out;

import com.ricardo.hexagonal_architecture.adapters.out.repositories.CustomerRepository;
import com.ricardo.hexagonal_architecture.application.ports.out.DeleteCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
