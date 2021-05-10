package com.tranhuudat.htttquanli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="ware_house")

public class WareHouse extends BaseEntity<String> implements Serializable {

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name="item_id")
    private Item item;

    private int quantity;
}
