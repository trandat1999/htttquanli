package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.model.Role;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import com.tranhuudat.htttquanli.repository.RoleRepository;
import com.tranhuudat.htttquanli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Account checkLogin(Account account) {
        if(account!=null){
            return accountRepository.findAccount(account.getUsername(), account.getPassword());
        }
        return null;
    }

    @Override
    public Account saveOrUpdate(Account account) {
        try {
            if(account.getRole()!=null && account.getRole().getId()>0l){
                Role role= roleRepository.findById(account.getRole().getId()).get();
                if(role!=null){
                    account.setRole(role);
                }
            }
            account=accountRepository.save(account);
            return account;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> getPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return accountRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(long id) {
        try {
            accountRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
