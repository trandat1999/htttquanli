package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.dto.ResponseErrDto;
import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.model.Customer;
import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.model.Supplier;
import com.tranhuudat.htttquanli.repository.CustomerRepository;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import com.tranhuudat.htttquanli.repository.SupplierRepository;
import com.tranhuudat.htttquanli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/")
public class AdminController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping(value = "image/{id}")
    public void getImage(@PathVariable("id") long id, HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {
        Item item = itemRepository.findById(id).get();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getPicture());
        response.getOutputStream().close();
    }

    @PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account account1= accountService.checkLogin(account);
        if(account1!=null){
            return new ResponseEntity<>(account1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="getCustomerPhone")
    public ResponseEntity<?> findByPhone(@RequestBody SearchDto searchDto){
        Customer customer= customerRepository.findByPhoneNumber(searchDto.getPhoneNumber());
        if(customer!=null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }else{
            ResponseErrDto responseErrDto= new ResponseErrDto();
            responseErrDto.setMess("Không tìm thấy dữ liệu");
            responseErrDto.setStatus(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(responseErrDto,HttpStatus.OK);
        }

    }

    @PostMapping(value="getSupplierPhone")
    private ResponseEntity<Supplier> findByPhoneSu(@RequestBody SearchDto searchDto){

        return new ResponseEntity<>(supplierRepository.findByPhoneNumber(searchDto.getPhoneNumber()),HttpStatus.OK);
    }

}
