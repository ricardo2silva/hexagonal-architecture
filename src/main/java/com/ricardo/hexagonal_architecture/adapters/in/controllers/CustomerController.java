package com.ricardo.hexagonal_architecture.adapters.in.controllers;

import com.ricardo.hexagonal_architecture.adapters.in.controllers.mapper.CustomerMapper;
import com.ricardo.hexagonal_architecture.adapters.in.controllers.request.CustomerRequest;
import com.ricardo.hexagonal_architecture.adapters.in.controllers.response.CustomerResponse;
import com.ricardo.hexagonal_architecture.application.ports.in.DeleteCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
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
    private final UpdateCustomerInputPort updateCustomerByIdInputPort;
    private final DeleteCustomerInputPort deleteCustomerInputPort;

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
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponse> updateById(@PathVariable("id") final String id, @RequestBody @Valid CustomerRequest customerRequest ){
       var customer = updateCustomerByIdInputPort.update(id,customerRequest);
       return ResponseEntity.ok(customertMapper.toCustomerResponse(customer));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id ){
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
