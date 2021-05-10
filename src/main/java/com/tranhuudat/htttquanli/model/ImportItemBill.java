package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "import_item_bill")
@Data
public class ImportItemBill extends BaseEntity<String> implements Serializable {
    private Date dateImport;
    private String note;
    private ImportBillStatus status;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "importItemBill", orphanRemoval = true)
    private List<ImportItem> importItem;

    @ManyToOne(targetEntity = Supplier.class, cascade =CascadeType.ALL)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}
