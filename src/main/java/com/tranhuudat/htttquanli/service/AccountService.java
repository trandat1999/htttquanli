package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.model.Account;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    Account checkLogin(Account account);
    Account saveOrUpdate(Account account);
    List<Account> getAll();
    Page<Account> getPage(int page,int pageSize);
    Boolean delete(long id);
}
