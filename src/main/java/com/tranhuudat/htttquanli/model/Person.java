package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@Data
public abstract class Person extends BaseEntity<String>{
    private String email;
    private String phoneNumber;

    @JoinColumn(name="full_name_id")
    @OneToOne(targetEntity = FullName.class, cascade = CascadeType.ALL)
    private FullName fullName;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
}
