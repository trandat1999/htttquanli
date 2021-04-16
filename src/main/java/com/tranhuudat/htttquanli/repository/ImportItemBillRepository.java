package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.ImportItemBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportItemBillRepository extends JpaRepository<ImportItemBill,Long> {
}
