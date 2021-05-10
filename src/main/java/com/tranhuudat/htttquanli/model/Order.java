package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity<String> implements Serializable {
    private Date orderDate;
    private String details;
    private Double totals;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = false,cascade = CascadeType.ALL, mappedBy = "order")
    private Set<ItemOrder> itemOrderList;

}
