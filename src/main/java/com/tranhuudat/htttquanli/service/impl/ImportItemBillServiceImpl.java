package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.*;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.ImportItemBillRepository;
import com.tranhuudat.htttquanli.repository.ImportItemRepository;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.service.ImportItemBillService;
import com.tranhuudat.htttquanli.service.SupplierService;
import com.tranhuudat.htttquanli.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    private ImportItemRepository importItemRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WareHouseService wareHouseService;

    @Override
    public ImportItemBill saveOrUpdate(ImportItemBill importItemBill) {
        if(importItemBill!=null){

            if(importItemBill.getSupplier()!=null && importItemBill.getSupplier().getId()>0l){
                Supplier supplier= supplierService.findById(importItemBill.getSupplier().getId());
                importItemBill.setSupplier(supplier);
            }
            if(importItemBill.getAccount()!=null && importItemBill.getAccount().getId()>0l){
                Account account= accountRepository.findById(importItemBill.getAccount().getId()).get();
                if(account!=null && account.getUsername()!=null){
                    if(importItemBill.getId()>0l){
                        importItemBill.setLastModifiedBy(account.getUsername());
                    }else{
                        importItemBill.setCreatedBy(account.getUsername());
                    }
                }
                importItemBill.setAccount(account);
            }
            List<ImportItem> importItemList= new ArrayList<>();
            if(importItemBill.getImportItem()!=null && importItemBill.getImportItem().size()>0){
                for (ImportItem importItem: importItemBill.getImportItem()){
                    if(importItem.getItem()!=null && importItem.getItem().getId()>0l){
                        Item item  = itemRepository.findById(importItem.getItem().getId()).get();
                        if(item!=null){
                            importItem.setItem(item);
                            importItemList.add(importItem);
                        }else {
                            continue;
                        }
                    }
                }
            }

            importItemBill.setImportItem(importItemList);
            importItemBill.setDateImport(new Date());

            try {
                importItemBill= importItemBillRepository.save(importItemBill);
                if(importItemBill.getImportItem()!=null && importItemBill.getImportItem().size()>0){
                    for (ImportItem importItem: importItemBill.getImportItem()){
                        WareHouse wareHouse= new WareHouse();
                        wareHouse.setItem(importItem.getItem());
                        wareHouse.setQuantity(importItem.getQuantity());
                        wareHouseService.saveOrUpdate(wareHouse);
                    }
                }
                return importItemBill;
            }catch (Exception e){
                return null;
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
            String sql="select iib from ImportItemBill iib ";
            String where=" where 1=1";
            if(searchDto.getStartDate()!=null){
                where+=" and iib.createdDate >= :startDate ";
            }
            if(searchDto.getEndDate()!=null){
                where+=" and iib.createdDate <= :endDate ";
            }
            sql+=where;

            Query query= entityManager.createQuery(sql,ImportItemBill.class);
            if(searchDto.getStartDate()!=null){
                Date startDate= searchDto.getStartDate();
                startDate.setHours(0);
                startDate.setMinutes(0);
                startDate.setSeconds(0);
                query.setParameter("startDate", startDate);
            }
            if(searchDto.getEndDate()!=null){
                Date startDate= searchDto.getEndDate();
                startDate.setHours(0);
                startDate.setMinutes(0);
                startDate.setSeconds(0);
                query.setParameter("endDate", startDate);
            }
            List<ImportItemBill> list= query.getResultList();
            return list;
        }
        return null;
    }
}
