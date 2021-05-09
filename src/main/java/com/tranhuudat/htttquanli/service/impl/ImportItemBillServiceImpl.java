package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import com.tranhuudat.htttquanli.model.Supplier;
import com.tranhuudat.htttquanli.repository.ImportItemBillRepository;
import com.tranhuudat.htttquanli.service.ImportItemBillService;
import com.tranhuudat.htttquanli.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ImportItemBillServiceImpl implements ImportItemBillService {

    @Autowired
    private ImportItemBillRepository importItemBillRepository;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public ImportItemBill saveOrUpdate(ImportItemBill importItemBill) {
        if(importItemBill!=null){
            if(importItemBill.getId()>0l){
                importItemBill.setLastModifiedBy(importItemBill.getLastModifiedBy());
                try {
                    importItemBill= importItemBillRepository.save(importItemBill);
                    return importItemBill;
                }catch (Exception e){
                    return null;
                }
            }else{
                importItemBill.setCreatedBy(importItemBill.getCreatedBy());
                if(importItemBill.getSupplier()!=null && importItemBill.getSupplier().getId()>0l){
                    Supplier supplier= supplierService.findById(importItemBill.getSupplier().getId());
                    importItemBill.setSupplier(supplier);
                }
                try {
                    importItemBill= importItemBillRepository.save(importItemBill);
                    return importItemBill;
                }catch (Exception e){
                    return null;
                }

            }
        }
        return null;
    }

    @Override
    public List<ImportItemBill> findAll() {
        return importItemBillRepository.findAll();
    }

    @Override
    public Page<ImportItemBill> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return importItemBillRepository.findAll(pageable);
    }

    @Override
    public List<ImportItemBill> search(SearchDto searchDto) {
        if(searchDto!=null){
            String sql="select iib from ImportItemBill iib";
            String where="1=1";
            if(searchDto.getStartDate()!=null){
                where+="and iib.createdDate >= :startDate";
            }
            if(searchDto.getEndDate()!=null){
                where+="and iib.createdDate <= :endDate";
            }
            sql+=where;

            Query query= entityManager.createQuery(sql,ImportItemBill.class);
            if(searchDto.getStartDate()!=null){
                query.setParameter("startDate", searchDto.getStartDate());
            }
            if(searchDto.getEndDate()!=null){
                query.setParameter("endDate", searchDto.getEndDate());
            }
            List<ImportItemBill> list= query.getResultList();
            return list;
        }
        return null;
    }
}
