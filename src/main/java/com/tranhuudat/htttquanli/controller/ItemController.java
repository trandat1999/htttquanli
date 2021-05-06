package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Item;

import com.tranhuudat.htttquanli.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping(value = "/admin/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity<>(itemService.findAllItem(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") long id){
        return new ResponseEntity<>(itemService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{page}/{pageSize}")
    public ResponseEntity<List<Item>> getPage(@PathVariable("page") int page,@PathVariable("pageSize") int pageSize){
        Page<Item> pageModel= itemService.findPage(page, pageSize);
        List<Item> listItem= pageModel.getContent();
        return new ResponseEntity<>(listItem, HttpStatus.OK);
    }


    @PostMapping(value="/add")
    public ResponseEntity<Item> pEntity(@RequestBody Item item) {
        item= itemService.saveItem(item);
        if(item==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(item,HttpStatus.OK);
        }
    }


    @PutMapping(value="edit/{id}")
    public ResponseEntity<Item> putMethodName(@PathVariable long id, @RequestBody  Item entity) {
        Item item= itemService.findById(id);
        if(item==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(itemService.saveItem(entity), HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        Item item= itemService.findById(id);
        if(item==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            itemService.deleteItemById(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }
    }
}
