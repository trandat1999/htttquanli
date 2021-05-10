package com.tranhuudat.htttquanli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data

public class Address extends BaseEntity<String> implements Serializable {

    private String city;
    private String country;
    private String streets;
}
