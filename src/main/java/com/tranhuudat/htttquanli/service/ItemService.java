package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {
    List<Item> findAllItem();
    Item saveItem(Item itemModel);
    void deleteItemById(long id);
    Item getItemById(long id);
    Page<Item> findPage(int page, int pageSize);
    Item findByName(String name);
    Item findById(Long id);
}
