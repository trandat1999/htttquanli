package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepo;

    @Override
    public List<Item> findAllItem() {
        return itemRepo.findAll();
    }

    @Override
    public Item saveItem(Item itemModel) {
        try {
            return itemRepo.save(itemModel);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteItemById(long id) {
        itemRepo.deleteById(id);
    }

    @Override
    public Item getItemById(long id) {
        return  itemRepo.findById(id).get();
    }

    @Override
    public Page<Item> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1, pageSize);
        return this.itemRepo.findAll(pageable);
    }

    @Override
    public Item findByName(String name) {
        return (Item) this.itemRepo.findByName(name);
    }

    @Override
    public Item findById(Long id) {
        return itemRepo.findById(id).get();
    }
}
