package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.Customer;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import com.tranhuudat.htttquanli.model.Order;
import com.tranhuudat.htttquanli.repository.CustomerRepository;
import com.tranhuudat.htttquanli.repository.OrderRepository;
import com.tranhuudat.htttquanli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Order saveOrUpdate(Order order) {
        if(order!=null){
            if(order.getCustomer()!=null && order.getCustomer().getId()>0l){
                Customer customer= customerRepository.findById(order.getCustomer().getId()).get();
                if(customer!=null){
                    order.setCustomer(customer);
                }
            }
            try {
                order= orderRepository.save(order);
                return order;
            }catch (Exception e){
                return null;
            }

        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return orderRepository.findAll(pageable);
    }

    @Override
    public List<Order> search(SearchDto searchDto) {
        if(searchDto!=null){
            String sql="select o from Order o";
            String where="1=1";
            if(searchDto.getStartDate()!=null){
                where+="and o.createdDate >= :startDate";
            }
            if(searchDto.getEndDate()!=null){
                where+="and o.createdDate <= :endDate";
            }
            sql+=where;
            Query query= entityManager.createQuery(sql, Order.class);
            if(searchDto.getStartDate()!=null){
                query.setParameter("startDate", searchDto.getStartDate());
            }
            if(searchDto.getEndDate()!=null){
                query.setParameter("endDate", searchDto.getEndDate());
            }
            List<Order> list= query.getResultList();
            return list;
        }
        return null;
    }
}
