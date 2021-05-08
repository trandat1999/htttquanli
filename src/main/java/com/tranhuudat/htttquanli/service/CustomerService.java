package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(long id);
}
