package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.Customer;
import com.tranhuudat.htttquanli.repository.CustomerRepository;
import com.tranhuudat.htttquanli.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }
}
