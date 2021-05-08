package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);

    @Query("select  acc from Account acc where acc.username=?1 and acc.password=?2")
    Account findAccount(String username, String password);
}
