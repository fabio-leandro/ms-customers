package com.fabio.customercontrolapi.controllers;

import com.fabio.customercontrolapi.controllers.validations.CustomerValidationsErrors;
import com.fabio.customercontrolapi.dtos.CustomerDTO;
import com.fabio.customercontrolapi.exceptions.CustomerNotFoundException;
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

    private CustomerService customerService;

    public CustomerController(CustomerService springDataCustomerService) {
        this.customerService = springDataCustomerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@RequestBody @Valid CustomerDTO customerDTO){
       CustomerDTO customerDTOReponse = customerService.save(customerDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(customerDTOReponse);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerDTO> findByCpf(@PathVariable String cpf) throws CustomerNotFoundException {
        CustomerDTO customerDTO = customerService.findByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
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
