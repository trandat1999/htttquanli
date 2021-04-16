package com.tranhuudat.htttquanli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tbl_full_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName extends BaseEntity<String>{
    private String firstName;
    private String midName;
    private String lastName;
}
