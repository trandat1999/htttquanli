package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Order;
import com.tranhuudat.htttquanli.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/save",consumes = MediaType.ALL_VALUE,produces="application/json")
    @ResponseBody
    public ResponseEntity<Order> saveOrUpdate(@RequestBody Order order){
        Order order1 = orderService.saveOrUpdate(order);
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{page}/{pagesize}")
    public Page<Order> findPage(@PathVariable("page") int page, @PathVariable("pagesize") int pagSize){
        return orderService.findPage(page,pagSize);
    }

    @GetMapping(value = "/all")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping(value = "/findByStatus")
    public List<Order> findByStatus(){
        return orderService.findByStatus();
    }
}
