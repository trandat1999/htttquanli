package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import com.tranhuudat.htttquanli.repository.ImportItemBillRepository;
import com.tranhuudat.htttquanli.service.ImportItemBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportItemBillServiceImpl implements ImportItemBillService {

    @Autowired
    private ImportItemBillRepository importItemBillRepository;
    @Override
    public ImportItemBill saveOrUpdate(ImportItemBill importItemBill) {
        try {
            importItemBill= importItemBillRepository.save(importItemBill);
            return importItemBill;
        }catch (Exception e){
            return null;
        }
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
        return null;
    }
}
