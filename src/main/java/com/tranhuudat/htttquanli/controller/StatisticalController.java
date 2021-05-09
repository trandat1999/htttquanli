package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.service.ImportItemService;
import com.tranhuudat.htttquanli.service.ItemOrderService;
import com.tranhuudat.htttquanli.service.MaintainingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/statistical")
public class StatisticalController {

    @Autowired
    private MaintainingFeeService maintainingFeeService;

    @Autowired
    private ImportItemService importItemService;

    @Autowired
    private ItemOrderService itemOrderService;

    @GetMapping(value = "/maintaining")
    public ResponseEntity<?> getAllMain(){
        return new ResponseEntity<>(maintainingFeeService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/maintaining")
    public ResponseEntity<?> getAllMainSearch(SearchDto searchDto){
        return new ResponseEntity<>(maintainingFeeService.search(searchDto), HttpStatus.OK) ;
    }

    @GetMapping(value = "/importItem")
    public ResponseEntity<?> getAllImport(){
        return new ResponseEntity<>(importItemService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/importItem")
    public ResponseEntity<?> getAllImportSearch(SearchDto searchDto){
        return new ResponseEntity<>(importItemService.search(searchDto), HttpStatus.OK) ;
    }

    @GetMapping(value = "/itemOrder")
    public ResponseEntity<?> getAllItemOrder(){
        return new ResponseEntity<>(itemOrderService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/maintaining")
    public ResponseEntity<?> getAllItemOrderSearch(SearchDto searchDto){
        return new ResponseEntity<>(itemOrderService.search(searchDto), HttpStatus.OK) ;
    }
}
