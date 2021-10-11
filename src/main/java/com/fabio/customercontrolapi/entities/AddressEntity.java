package com.fabio.customercontrolapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="tb_addresses")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressCode;
    private String address;
    private String city;
    private String state;
    private String country;
    private String cep;
}
