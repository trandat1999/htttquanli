
package com.tranhuudat.htttquanli.controller;

import java.util.List;

import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.model.Address;
import com.tranhuudat.htttquanli.model.Employee;
import com.tranhuudat.htttquanli.model.FullName;
import com.tranhuudat.htttquanli.model.Role;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.AddressRepository;
import com.tranhuudat.htttquanli.repository.EmployeeRepository;
import com.tranhuudat.htttquanli.repository.FullNameRepository;
import com.tranhuudat.htttquanli.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AccountController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FullNameRepository fullNameRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeRepository employeeRepository;



}
