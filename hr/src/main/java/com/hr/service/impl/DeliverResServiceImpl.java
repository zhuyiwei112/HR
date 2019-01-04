package com.hr.service.impl;

import com.hr.dao.DeliverResDao;
import com.hr.model.DeliverRes;
import com.hr.service.DeliverResService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeliverResServiceImpl implements DeliverResService {
    @Resource
    private DeliverResDao deliverResDao;

    @Override
    public int addDRes(DeliverRes deliverRes) {
        if (deliverRes!=null) {
            DeliverRes deliverRes1 = deliverResDao.getDResByRid(deliverRes.getResume().getId());//投一次简历
            if (deliverRes1==null){
                if (deliverResDao.addDRes(deliverRes)){
                    return 1;//成功
                }else {
                    return 2;//失败
                }
            }
            return 0;//重复
        }
        return -1;
    }

    @Override
    public boolean updateDRes(DeliverRes deliverRes) {
        if (deliverRes.getId()!=null){
            return deliverResDao.updateDRes(deliverRes);
        }
        return false;
    }

    @Override
    public List<DeliverRes> getAllDres() {
        return deliverResDao.getAllDRes();
    }

    @Override
    public DeliverRes getDResByRid(Integer rid) {
        if (rid!=null){
            return deliverResDao.getDResByRid(rid);
        }
        return null;
    }
}
