package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tbl_employee")
@Data
public class Employee extends Person implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;

    private float coefficientsSalary;
}
