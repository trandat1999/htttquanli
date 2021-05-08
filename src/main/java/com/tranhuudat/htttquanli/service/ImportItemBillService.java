package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItemBill;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ImportItemBillService {
    ImportItemBill saveOrUpdate(ImportItemBill importItemBill);
    List<ImportItemBill> findAll();
    Page<ImportItemBill> findPage(int page,int pageSize);
    List<ImportItemBill> search(SearchDto searchDto);
}
