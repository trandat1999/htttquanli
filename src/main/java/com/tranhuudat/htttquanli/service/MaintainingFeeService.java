package com.tranhuudat.htttquanli.service;

import com.tranhuudat.htttquanli.dto.SearchDto;
import com.tranhuudat.htttquanli.model.MaintainingFee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MaintainingFeeService {
    MaintainingFee saveOrUpdate(MaintainingFee maintainingFee);
    List<MaintainingFee> findAll();
    Page<MaintainingFee> findPage(int page,int pageSize);
    MaintainingFee findById(long id);
    List<MaintainingFee> search(SearchDto searchDto);
}
