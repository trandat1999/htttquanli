package com.tranhuudat.htttquanli.controller;


import com.tranhuudat.htttquanli.model.MaintainingFee;
import com.tranhuudat.htttquanli.model.Order;
import com.tranhuudat.htttquanli.service.MaintainingFeeService;
import com.tranhuudat.htttquanli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/maintainFee")
@CrossOrigin("*")
public class MaintainingFeeController {
    @Autowired
    private MaintainingFeeService orderService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MaintainingFee> saveOrUpdate(@RequestBody MaintainingFee order){
        order = orderService.saveOrUpdate(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{page}/{pagesize}")
    public Page<MaintainingFee> findPage(@PathVariable("page") int page, @PathVariable("pagesize") int pagSize){
        return orderService.findPage(page,pagSize);
    }

    @GetMapping(value = "/all")
    public List<MaintainingFee> findAll(){
        return orderService.findAll();
    }
}
