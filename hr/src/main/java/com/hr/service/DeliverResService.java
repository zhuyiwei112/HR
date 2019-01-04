package com.hr.service;

import com.hr.model.DeliverRes;

import java.util.List;

public interface DeliverResService {
    int addDRes(DeliverRes deliverRes);
    boolean updateDRes(DeliverRes deliverRes);
    List<DeliverRes> getAllDres();
    DeliverRes getDResByRid(Integer rid);
}
