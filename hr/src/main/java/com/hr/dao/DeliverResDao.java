package com.hr.dao;

import com.hr.model.DeliverRes;

import java.util.List;

public interface DeliverResDao {
    boolean addDRes(DeliverRes deliverRes);
    boolean delDRes(DeliverRes deliverRes);
    boolean updateDRes(DeliverRes deliverRes);
    DeliverRes getDResByRid(Integer rid);
    List<DeliverRes> getAllDRes();
}
