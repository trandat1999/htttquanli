package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.ImportItem;
import com.tranhuudat.htttquanli.repository.ImportItemRepository;
import com.tranhuudat.htttquanli.service.ImportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportServiceImpl implements ImportItemService {

    @Autowired
    private ImportItemRepository importItemRepository;

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
        return null;
    }
}
