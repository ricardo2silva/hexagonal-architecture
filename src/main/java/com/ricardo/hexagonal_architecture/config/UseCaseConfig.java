package com.ricardo.hexagonal_architecture.config;

import com.ricardo.hexagonal_architecture.adapters.out.*;
import com.ricardo.hexagonal_architecture.adapters.out.repositories.mapper.CustomerEntityMapper;
import com.ricardo.hexagonal_architecture.application.core.usecase.DeleteCustomerUseCase;
import com.ricardo.hexagonal_architecture.application.core.usecase.FindCustomerByIdUseCase;
import com.ricardo.hexagonal_architecture.application.core.usecase.InsertCustomerUseCase;
import com.ricardo.hexagonal_architecture.application.core.usecase.UpdateCustomerUseCase;
import com.ricardo.hexagonal_architecture.application.ports.in.DeleteCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
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

    @Bean
    public UpdateCustomerInputPort updateCustomerByIdInputPort(
            FindCustomerByIdAdapter findCustomerByIdAdapter, UpdateCustomerAdapter updateCustomerByIdAdapter, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, CustomerEntityMapper customerEntityMapper) {
        return new UpdateCustomerUseCase(findCustomerByIdAdapter,updateCustomerByIdAdapter,findAddressByZipCodeAdapter,customerEntityMapper);
    }

    @Bean
    public DeleteCustomerInputPort deleteCustomerInputPort(DeleteCustomerAdapter deleteCustomerAdapter,FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new DeleteCustomerUseCase(deleteCustomerAdapter,findCustomerByIdAdapter);
    }
}

