package com.fabio.customercontrolapi.controllers;

import com.fabio.customercontrolapi.dtos.CustomerDTO;
import com.fabio.customercontrolapi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService springDataCustomerService;

    public CustomerController(CustomerService springDataCustomerService) {
        this.springDataCustomerService = springDataCustomerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@RequestBody @Valid CustomerDTO customerDTO){
       CustomerDTO customerDTOReponse = springDataCustomerService.save(customerDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(customerDTOReponse);
    }


}
