package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="item")
@Data
public class Item extends BaseEntity<String>{
    @Column(name = "name", unique = true)
    private String name;
    private String shortDescription;
    private String description;
    private double price;
    @Lob
    private byte[] picture;
    @JoinColumn(name = "category")
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Category.class, cascade = CascadeType.ALL)
    private Category category;
}
