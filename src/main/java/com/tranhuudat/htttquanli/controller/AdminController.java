package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.repository.ItemRepository;
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

    @GetMapping(value = "image/{id}")
    public void getImage(@PathVariable("id") long id, HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {
        Item item = itemRepository.findById(id).get();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getPicture());
        response.getOutputStream().close();
    }

    @PostMapping("login")
    private ResponseEntity<Account> login(@RequestBody Account account) {
        Account account1= accountService.checkLogin(account);
        if(account1!=null){
            return new ResponseEntity<>(account1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
