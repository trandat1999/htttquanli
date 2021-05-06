package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category")
@Data
public class Category extends BaseEntity<String>{
    private String name;

    @Column(unique = true)
    private String code;
}
