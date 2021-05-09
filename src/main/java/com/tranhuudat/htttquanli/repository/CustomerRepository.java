package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByPhoneNumber(String phoneNumber);
}
