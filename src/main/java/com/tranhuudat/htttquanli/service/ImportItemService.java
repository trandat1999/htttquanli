package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ImportItemService {
    List<ImportItem> findAll();
    Page<ImportItem> findPage(int page, int pageSize);
    List<ImportItem> search(SearchDto searchDto);
}
