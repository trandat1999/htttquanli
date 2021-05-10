package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "sipplier")
public class Supplier extends BaseEntity<String> implements Serializable {
    private String name;
    private String address;
    @Column(unique = true)
    private String phoneNumber;
    private String description;
    private String email;
}
