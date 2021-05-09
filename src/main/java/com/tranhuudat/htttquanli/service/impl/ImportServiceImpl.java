package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItem;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import com.tranhuudat.htttquanli.repository.ImportItemRepository;
import com.tranhuudat.htttquanli.service.ImportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class ImportServiceImpl implements ImportItemService {

    @Autowired
    private ImportItemRepository importItemRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ImportItem> findAll() {
        return importItemRepository.findAll();
    }

    @Override
    public Page<ImportItem> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return importItemRepository.findAll(pageable);
    }

    @Override
    public List<ImportItem> search(SearchDto searchDto) {
        if(searchDto!=null){
            String sql="select ii from ImportItem ii";
            String where="1=1";
            if(searchDto.getStartDate()!=null){
                where+="and ii.createdDate >= :startDate";
            }
            if(searchDto.getEndDate()!=null){
                where+="and ii.createdDate <= :endDate";
            }
            sql+=where;

            Query query= entityManager.createQuery(sql, ImportItem.class);
            if(searchDto.getStartDate()!=null){
                query.setParameter("startDate", searchDto.getStartDate());
            }
            if(searchDto.getEndDate()!=null){
                query.setParameter("endDate", searchDto.getEndDate());
            }
            List<ImportItem> list= query.getResultList();
            return list;
        }
        return null;
    }
}
