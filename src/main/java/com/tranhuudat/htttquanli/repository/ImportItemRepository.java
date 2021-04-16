package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.ImportItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportItemRepository extends JpaRepository<ImportItem,Long> {
}
