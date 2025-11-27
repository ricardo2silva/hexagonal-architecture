package com.ricardo.hexagonal_architecture.config;

import com.ricardo.hexagonal_architecture.adapters.out.FindAddressByZipCodeAdapter;
import com.ricardo.hexagonal_architecture.adapters.out.FindCustomerByIdAdapter;
import com.ricardo.hexagonal_architecture.adapters.out.InsertCustomerAdapter;
import com.ricardo.hexagonal_architecture.application.core.usecase.FindCustomerByIdUseCase;
import com.ricardo.hexagonal_architecture.application.core.usecase.InsertCustomerUseCase;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public InsertCustomerInputPort insertCustomerInputPort(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdInputPort(
            FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}

