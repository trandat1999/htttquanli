package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="import_item")
@Data
public class ImportItem extends BaseEntity<String> implements Serializable {
    private double priceImport;
    private int quantity;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne(targetEntity = ImportItemBill.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="import_item_bill_id")
    private ImportItemBill importItemBill;
}
