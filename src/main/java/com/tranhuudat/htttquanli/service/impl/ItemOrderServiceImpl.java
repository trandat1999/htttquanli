package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ItemOrder;
import com.tranhuudat.htttquanli.repository.ItemOrderRepository;
import com.tranhuudat.htttquanli.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    @Autowired
    private ItemOrderRepository itemOrderRepository;
    @Override
    public List<ItemOrder> findAll() {
        return itemOrderRepository.findAll();
    }

    @Override
    public Page<ItemOrder> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return itemOrderRepository.findAll(pageable);
    }

    @Override
    public List<ItemOrder> search(SearchDto searchDto) {
        return null;
    }
}
