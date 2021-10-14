package com.fabio.customercontrolapi.services;


import com.fabio.customercontrolapi.dtos.CustomerDTO;
import com.fabio.customercontrolapi.entities.CustomerEntity;
import com.fabio.customercontrolapi.exceptions.CustomerNotFoundException;
import com.fabio.customercontrolapi.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    public CustomerDTO save(CustomerDTO customerDTO){
        CustomerEntity customerEntity = modelMapper.map(customerDTO,CustomerEntity.class);
        customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }

    public CustomerDTO findByCpf(String cpf) throws CustomerNotFoundException {
        CustomerEntity customerEntity = customerRepository.findByCpf(cpf)
                .orElseThrow(() -> new CustomerNotFoundException("Not found Customer with cpf: "+cpf));
        return  modelMapper.map(customerEntity,CustomerDTO.class);
    }








}
