package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name="ware_house")
public class WareHouse extends BaseEntity<String>{

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name="item_id")
    private Item item;

    private int quantity;
}
