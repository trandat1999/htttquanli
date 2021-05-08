package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.Order;
import com.tranhuudat.htttquanli.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order saveOrUpdate(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Page<Order> findPage(int page, int pageSize) {
        return null;
    }

    @Override
    public List<Order> search(SearchDto searchDto) {
        return null;
    }
}
