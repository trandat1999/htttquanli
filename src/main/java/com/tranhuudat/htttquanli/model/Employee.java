package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")
@Data
public class Employee extends Person{
    private float mantainFee;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private float coefficientsSalary;
}
