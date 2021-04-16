package com.tranhuudat.htttquanli.security;

import com.tranhuudat.htttquanli.model.Account;
import com.tranhuudat.htttquanli.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        AccountDetails accountDetails = new AccountDetails(account.getUsername(), account.getPassword(),
                true, true, true, true,
                AuthorityUtils.createAuthorityList(account.getRole().getName()));
        return accountDetails;
    }
}
