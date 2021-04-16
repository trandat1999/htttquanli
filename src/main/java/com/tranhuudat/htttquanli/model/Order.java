package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_order")
@Data
public class Order extends BaseEntity<String>{
    private Date orderDate;
    private String details;
    private Double totals;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = false,cascade = CascadeType.ALL, mappedBy = "order")
    private List<ItemOrder> itemOrderList;
}
