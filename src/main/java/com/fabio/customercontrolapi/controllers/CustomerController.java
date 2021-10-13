package com.fabio.customercontrolapi.controllers;

import com.fabio.customercontrolapi.controllers.validations.CustomerValidationsErrors;
import com.fabio.customercontrolapi.dtos.CustomerDTO;
import com.fabio.customercontrolapi.services.CustomerService;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handlerValidationException(MethodArgumentNotValidException ex){
        return new CustomerValidationsErrors().callValidatorsException(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException.class)
    public Map<String, Object> callJsonParseException(){
        return new CustomerValidationsErrors().callJsonException();
    }

}
