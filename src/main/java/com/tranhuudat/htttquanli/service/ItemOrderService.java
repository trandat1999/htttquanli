package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.model.ItemOrder;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemOrderService {
    List<ItemOrder> findAll();
    Page<ItemOrder> findPage(int page,int pageSize);
    List<ItemOrder> search(SearchDto searchDto);
}
