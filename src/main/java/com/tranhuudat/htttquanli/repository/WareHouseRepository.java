package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
    @Query("select wh from WareHouse wh where wh.item.id=?1")
    WareHouse findByIdItem(long id);
}
