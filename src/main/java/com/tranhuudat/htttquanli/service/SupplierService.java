package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier findById(long id);
}
