package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.MaintainingFee;
import com.tranhuudat.htttquanli.repository.MaintainingFeeRepository;
import com.tranhuudat.htttquanli.service.MaintainingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainingFeeServiceImpl implements MaintainingFeeService {
    @Autowired
    private MaintainingFeeRepository maintainingFeeRepository;
    @Override
    public MaintainingFee saveOrUpdate(MaintainingFee maintainingFee) {
        try{
            return maintainingFeeRepository.save(maintainingFee);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<MaintainingFee> findAll() {
        return maintainingFeeRepository.findAll();
    }

    @Override
    public Page<MaintainingFee> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return maintainingFeeRepository.findAll(pageable);
    }

    @Override
    public MaintainingFee findById(long id) {
        try {
            return maintainingFeeRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }
}
