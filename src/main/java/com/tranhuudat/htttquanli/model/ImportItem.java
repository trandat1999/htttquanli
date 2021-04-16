package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="import_item")
@Data
public class ImportItem extends BaseEntity<String>{
    private double priceImport;
    private int quantity;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(targetEntity = ImportItemBill.class)
    @JoinColumn(name="import_item_bill_id")
    private ImportItemBill importItemBill;
}
