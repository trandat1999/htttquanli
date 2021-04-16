package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "sipplier")
public class Supplier extends BaseEntity<String>{
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    private String email;
}
