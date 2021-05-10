package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Item;

import com.tranhuudat.htttquanli.model.WareHouse;
import com.tranhuudat.htttquanli.service.ItemService;
import com.tranhuudat.htttquanli.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private WareHouseService wareHouseService;

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


    @PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> pEntity(@RequestBody Item item) {
        System.out.println(item);
        Item item1= itemService.saveItem(item);
        System.out.println(item1);
        if(item1!=null){
            WareHouse wareHouse= new WareHouse();
            wareHouse.setItem(item1);
            wareHouse.setQuantity(0);
            wareHouseService.saveOrUpdate(wareHouse);
            return new ResponseEntity<>(item1,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value="edit/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
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
