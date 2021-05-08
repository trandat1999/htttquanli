package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    Order saveOrUpdate(Order order);
    List<Order> findAll();
    Page<Order> findPage(int page,int pageSize);
    List<Order> search(SearchDto searchDto);
}
