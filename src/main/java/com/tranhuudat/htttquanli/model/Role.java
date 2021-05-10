package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity<String> implements Serializable {
    private String name;
    private String code;
}
