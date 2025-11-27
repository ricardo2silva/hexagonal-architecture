package com.ricardo.hexagonal_architecture.adapters.in.controllers;

import com.ricardo.hexagonal_architecture.adapters.in.controllers.mapper.CustomerMapper;
import com.ricardo.hexagonal_architecture.adapters.in.controllers.request.CustomerRequest;
import com.ricardo.hexagonal_architecture.adapters.in.controllers.response.CustomerResponse;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customertMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest ){
        var customer = customertMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable("id") final String id ){
       var customer = findCustomerByIdInputPort.findById(id);
       return ResponseEntity.ok(customertMapper.toCustomerResponse(customer));

    }
}
