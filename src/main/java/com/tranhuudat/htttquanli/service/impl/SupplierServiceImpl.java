package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.Supplier;
import com.tranhuudat.htttquanli.repository.SupplierRepository;
import com.tranhuudat.htttquanli.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(long id) {
        return supplierRepository.findById(id).get();
    }
}
