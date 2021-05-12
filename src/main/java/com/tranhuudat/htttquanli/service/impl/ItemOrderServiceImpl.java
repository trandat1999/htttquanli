package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItem;
import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.model.ItemOrder;
import com.tranhuudat.htttquanli.repository.ItemOrderRepository;
import com.tranhuudat.htttquanli.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    private EntityManager entityManager;

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
        System.out.println(searchDto);
        if(searchDto!=null){
            String sql="select io from ItemOrder io ";
            String where=" where 1=1 ";
            if(searchDto.getStartDate()!=null){
                where+=" and io.createdDate >= :startDate ";
            }
            if(searchDto.getEndDate()!=null){
                where+=" and io.createdDate <= :endDate ";
            }
            sql+=where;

            Query query= entityManager.createQuery(sql, ItemOrder.class);
            if(searchDto.getStartDate()!=null){
                Date startDate= searchDto.getStartDate();
                startDate.setHours(0);
                startDate.setMinutes(0);
                startDate.setSeconds(0);
                query.setParameter("startDate", startDate);
            }
            if(searchDto.getEndDate()!=null){
                Date startDate= searchDto.getEndDate();
                startDate.setHours(23);
                startDate.setMinutes(59);
                startDate.setSeconds(59);
                query.setParameter("endDate", startDate);
            }
            List<ItemOrder> list= query.getResultList();
            return list;
        }
        return null;
    }
}
