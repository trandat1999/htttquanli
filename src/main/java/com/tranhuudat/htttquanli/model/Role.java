package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity<String>{
    private String name;
    private String code;
}
