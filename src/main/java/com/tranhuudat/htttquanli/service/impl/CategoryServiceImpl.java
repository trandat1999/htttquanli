package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.Category;
import com.tranhuudat.htttquanli.repository.CategoryRepository;
import com.tranhuudat.htttquanli.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addOrUpdate(Category categoryModel) {
        try {
            return categoryRepository.save(categoryModel);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Page<Category> findAll(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1, pageSize);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
