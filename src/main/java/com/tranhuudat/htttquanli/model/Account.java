package com.tranhuudat.htttquanli.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tbl_account")
@Data
public class Account extends BaseEntity<String>{
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "role")
    private Role role;
}
