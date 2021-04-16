package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
