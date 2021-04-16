package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
