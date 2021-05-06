package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category addOrUpdate(Category categoryModel);
    Category findById(long id);
    Page<Category> findAll(int page, int pageSize);
    void delete(long id);
}
