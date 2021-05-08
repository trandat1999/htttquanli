package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.*;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.EmployeeRepository;
import com.tranhuudat.htttquanli.repository.ImportItemBillRepository;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.repository.SupplierRepository;

import com.tranhuudat.htttquanli.service.ImportItemBillService;
import com.tranhuudat.htttquanli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/importBill")
public class ImportBillController {

    @Autowired
    private ImportItemBillService orderService;

    @PostMapping(value = "/save")
    public ResponseEntity<ImportItemBill> saveOrUpdate(@RequestBody ImportItemBill order){
        order = orderService.saveOrUpdate(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{page}/{pagesize}")
    public Page<ImportItemBill> findPage(@PathVariable("page") int page, @PathVariable("pagesize") int pagSize){
        return orderService.findPage(page,pagSize);
    }

    @GetMapping(value = "/findAll")
    public List<ImportItemBill> findAll(){
        return orderService.findAll();
    }

}
