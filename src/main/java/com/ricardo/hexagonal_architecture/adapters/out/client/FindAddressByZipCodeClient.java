package com.ricardo.hexagonal_architecture.adapters.out.client;

import com.ricardo.hexagonal_architecture.adapters.out.client.response.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${ricardo.client.address.url}")
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}/json")
    ViaCepResponse find(@PathVariable("zipCode") String zipCode);
}
