package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.WareHouse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WareHouseService {
    List<WareHouse> findAll();
    Page<WareHouse> findPage(int page,int pageSize);
    WareHouse saveOrUpdate(WareHouse wareHouse);
    boolean delete(long id);
    WareHouse updateOrder(WareHouse wareHouse);
}
