package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.service.ImportItemService;
import com.tranhuudat.htttquanli.service.ItemOrderService;
import com.tranhuudat.htttquanli.service.MaintainingFeeService;
import com.tranhuudat.htttquanli.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Autowired
    private WareHouseService wareHouseService;

    @GetMapping(value = "/getMaintaining")
    public ResponseEntity<?> getAllMain(){
        return new ResponseEntity<>(maintainingFeeService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/postMaintaining",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMainSearch(@RequestBody  SearchDto searchDto){
        System.out.println(searchDto);
        return new ResponseEntity<>(maintainingFeeService.search(searchDto), HttpStatus.OK) ;
    }

    @GetMapping(value = "/getImportItem")
    public ResponseEntity<?> getAllImport(){
        return new ResponseEntity<>(importItemService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/postImportItem",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllImportSearch(@RequestBody SearchDto searchDto){
        return new ResponseEntity<>(importItemService.search(searchDto), HttpStatus.OK) ;
    }

    @GetMapping(value = "/getItemOrder")
    public ResponseEntity<?> getAllItemOrder(){
        return new ResponseEntity<>(itemOrderService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/postItemOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllItemOrderSearch(@RequestBody SearchDto searchDto){
        return new ResponseEntity<>(itemOrderService.search(searchDto), HttpStatus.OK) ;
    }

    @GetMapping(value = "/warehouse")
    public  ResponseEntity<?> getAllWareHouse(){
        return new ResponseEntity<>(wareHouseService.findAll(),HttpStatus.OK) ;
    }
}
