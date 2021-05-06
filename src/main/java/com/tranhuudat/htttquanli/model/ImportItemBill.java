package com.tranhuudat.htttquanli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "import_item_bill")
@Data
public class ImportItemBill extends BaseEntity<String>{
    private Date dateImport;
    private String note;
    private ImportBillStatus status;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "importItemBill")
    @JsonIgnore
    private List<ImportItem> importItemList;

    @ManyToOne(targetEntity = Supplier.class, cascade =CascadeType.ALL)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}
