package com.fabio.customercontrolapi.entities;

import com.fabio.customercontrolapi.entities.enums.PhoneType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_phones")
public class PhoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long phoneCode;
    private PhoneType type;
    private String number;

}
