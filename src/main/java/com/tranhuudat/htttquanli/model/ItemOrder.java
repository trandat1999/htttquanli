package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_order")
@Data
public class ItemOrder extends BaseEntity<String>{

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name="order_id")
    private Order order;

    private double price;
    private int quantity;


}
