package com.fabio.customercontrolapi.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDTO {

    private Long customerCode;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min = 2)
    private String name;
    @NotNull(message = "The field cannot be blank.")
    private LocalDate birthDate;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min=11, max = 11, message = "The field must have 14 characters.")
    private String cpf;
    @NotNull(message = "The field cannot be null.")
    private Character gender;
    @NotNull(message = "The field cannot be null.")
    private AddressDTO address;
    @NotEmpty(message = "The field cannot be empty.")
    private List<PhoneDTO> phones;


}
