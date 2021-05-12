package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.*;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.CustomerRepository;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.repository.OrderRepository;
import com.tranhuudat.htttquanli.service.OrderService;
import com.tranhuudat.htttquanli.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private WareHouseService wareHouseService;

    @Override
    public Order saveOrUpdate(Order order) {
        System.out.println(order);
        if(order!=null){

            if(order.getId()>0l){
                order= orderRepository.findById(order.getId()).get();
                order.setStatus(Status.OK);

                return orderRepository.save(order);
            }
            if(order.getCustomer()!=null && order.getCustomer().getId()>0l){
                Customer supplier= customerRepository.findById(order.getCustomer().getId()).get();
                if(supplier!=null) {
                    order.setCustomer(supplier);
                }
            }
            order.setStatus(Status.NEW);
            if(order.getAccount()!=null && order.getAccount().getId()>0l){
                Account account= accountRepository.findById(order.getAccount().getId()).get();
                order.setAccount(account);
            }
            Set<ItemOrder> importItemList= new HashSet<>();
            if(order.getItemOrderList()!=null && order.getItemOrderList().size()>0){
                for (ItemOrder itemOrder: order.getItemOrderList()){
                    if(itemOrder.getItem()!=null && itemOrder.getItem().getId()>0l){
                        Item item  = itemRepository.findById(itemOrder.getItem().getId()).get();
                        if(item!=null){
                            itemOrder.setItem(item);
                            importItemList.add(itemOrder);
                        }else {
                            continue;
                        }
                    }
                }
            }

            order.setItemOrderList(importItemList);
            order.setOrderDate(new Date());
            try {
                order= orderRepository.save(order);
                if(order.getItemOrderList()!=null && order.getItemOrderList().size()>0){
                    for (ItemOrder importItem: order.getItemOrderList()){
                        WareHouse wareHouse= new WareHouse();
                        wareHouse.setItem(importItem.getItem());
                        wareHouse.setQuantity(importItem.getQuantity()*(-1));
                        wareHouseService.saveOrUpdate(wareHouse);
                    }
                }

                return order;
            }catch (Exception e){
                e.printStackTrace();
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
            String where=" where 1=1 ";
            if(searchDto.getStartDate()!=null){
                where+=" and o.createdDate >= :startDate ";
            }
            if(searchDto.getEndDate()!=null){
                where+=" and o.createdDate <= :endDate ";
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

    @Override
    public List<Order> findByStatus() {
        return orderRepository.findByStatus();
    }
}
