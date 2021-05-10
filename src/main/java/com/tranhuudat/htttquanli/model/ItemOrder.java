package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "item_order")
@Data
public class ItemOrder extends BaseEntity<String> implements Serializable {

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name="item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name="order_id")
    private Order order;

    private double price;
    private int quantity;


}
