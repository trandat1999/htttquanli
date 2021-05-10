package com.tranhuudat.htttquanli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tbl_full_name")
@Data

public class FullName extends BaseEntity<String> implements Serializable {
    private String firstName;
    private String midName;
    private String lastName;
}
