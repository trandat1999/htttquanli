package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Long> {
}
