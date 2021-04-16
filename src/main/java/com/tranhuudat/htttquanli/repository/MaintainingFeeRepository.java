package com.tranhuudat.htttquanli.repository;

import com.tranhuudat.htttquanli.model.MaintainingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainingFeeRepository extends JpaRepository<MaintainingFee,Long> {
}
