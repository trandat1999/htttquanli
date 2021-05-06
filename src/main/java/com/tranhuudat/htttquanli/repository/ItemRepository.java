package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Object findByName(String name);
}
