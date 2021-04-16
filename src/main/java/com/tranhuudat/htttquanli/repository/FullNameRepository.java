package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullNameRepository extends JpaRepository<FullName,Long> {
}
