package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("Select o from Order o where o.status='NEW'")
    List<Order> findByStatus();
}
