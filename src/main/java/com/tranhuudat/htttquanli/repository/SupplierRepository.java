package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByPhoneNumber(String phoneNumber);
}
