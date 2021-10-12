package com.fabio.customercontrolapi.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class AddressDTO {

    private Long addressCode;
    @NotEmpty(message = "The field cannot be blank.")
    @Size(min = 2, message = "Value invalid.")
    private String address;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min = 2, message = "Value invalid.")
    private String city;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min = 2, max = 2, message = "The field must have 2 characters.")
    private String state;
    @NotBlank(message = "The field cannot be blank.")
    private String country;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min = 8, max = 8, message = "The field must have 8 characters and just numbers.")
    private String cep;

}
