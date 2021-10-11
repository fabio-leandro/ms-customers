package com.fabio.customercontrolapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "tb_customers")
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerCode;
    private String name;

    private LocalDate birthDate;
    private String cpf;
    private Character gender;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REMOVE})
    private AddressEntity address = new AddressEntity();
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REMOVE})
    private List<PhoneEntity> phones = new ArrayList<>();
}
