package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "maintaining_fee")
public class MaintainingFee extends BaseEntity<String>{
    private float fee;
    private String note;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}
