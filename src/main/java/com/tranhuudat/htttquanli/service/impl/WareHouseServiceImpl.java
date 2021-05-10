package com.tranhuudat.htttquanli.service.impl;

import com.tranhuudat.htttquanli.model.WareHouse;
import com.tranhuudat.htttquanli.repository.WareHouseRepository;
import com.tranhuudat.htttquanli.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Override
    public List<WareHouse> findAll() {
        return wareHouseRepository.findAll();
    }

    @Override
    public Page<WareHouse> findPage(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return wareHouseRepository.findAll(pageable);
    }

    @Override
    public WareHouse saveOrUpdate(WareHouse wareHouse) {
        if(wareHouse!=null && wareHouse.getItem()!=null){
            WareHouse wareHouse1=null;
            if (wareHouse.getItem().getId()>0l){
                wareHouse1= wareHouseRepository.findByIdItem(wareHouse.getItem().getId());
                if(wareHouse1!=null){
                    wareHouse1.setQuantity(wareHouse1.getQuantity()+wareHouse.getQuantity());
                }else {
                    return null;
                }
            }
            try{
                if(wareHouse1!=null){
                    wareHouse1= wareHouseRepository.save(wareHouse1);
                    return wareHouse1;
                }else{
                    return null;
                }
            }catch (Exception exception){
                return null;
            }
        }

        return null;

    }
    @Override
    public WareHouse updateOrder(WareHouse wareHouse) {
        if(wareHouse!=null && wareHouse.getItem()!=null){
            WareHouse wareHouse1=null;
            if (wareHouse.getItem().getId()>0l){
                wareHouse1= wareHouseRepository.findByIdItem(wareHouse.getItem().getId());
                if(wareHouse1!=null){
                    wareHouse1.setQuantity(wareHouse1.getQuantity()+wareHouse.getQuantity());
                }else {
                    return null;
                }
            }
            try{
                if(wareHouse1!=null){
                    wareHouse1= wareHouseRepository.save(wareHouse1);
                    return wareHouse1;
                }else{
                    return null;
                }
            }catch (Exception exception){
                return null;
            }
        }

        return null;

    }

    @Override
    public boolean delete(long id) {
        if (id>0l){
            WareHouse wareHouse= wareHouseRepository.findById(id).get();
            if(wareHouse!=null){
                wareHouseRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}
