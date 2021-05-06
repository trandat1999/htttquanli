package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.model.Employee;
import com.tranhuudat.htttquanli.model.ImportBillStatus;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import com.tranhuudat.htttquanli.model.Supplier;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.EmployeeRepository;
import com.tranhuudat.htttquanli.repository.ImportItemBillRepository;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/importbill")
public class ImportBillController {

    @Autowired
    private ImportItemBillRepository importItemBillRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SupplierRepository supplierRepository;
    

}
