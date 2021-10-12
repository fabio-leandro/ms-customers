package com.fabio.customercontrolapi.dtos;

import com.fabio.customercontrolapi.entities.enums.PhoneType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Data
public class PhoneDTO {

    private Long phoneCode;
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    @NotEmpty(message = "The field cannot be empty.")
    private String number;


}
