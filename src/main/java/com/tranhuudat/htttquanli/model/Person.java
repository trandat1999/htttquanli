package com.tranhuudat.htttquanli.model;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Person extends BaseEntity<String>{
    private String email;
    private String phoneNumber;

    @JoinColumn(name="full_name_id")
    @OneToOne(targetEntity = FullName.class)
    private FullName fullName;

    @OneToOne(targetEntity = Address.class)
    @JoinColumn(name="address_id")
    private Address address;
}
