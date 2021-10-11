package com.fabio.customercontrolapi.dtos;

import com.fabio.customercontrolapi.entities.enums.PhoneType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class PhoneDTO {

    private Long phoneCode;
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    private String number;


}
