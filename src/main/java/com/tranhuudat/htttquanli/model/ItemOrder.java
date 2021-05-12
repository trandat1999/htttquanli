package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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


    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name="order_id")
    private Order order;

    private double price;
    private int quantity;


}
