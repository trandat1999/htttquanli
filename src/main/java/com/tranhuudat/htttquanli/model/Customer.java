package com.tranhuudat.htttquanli.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Data
public class Customer extends Person implements Serializable {
}
