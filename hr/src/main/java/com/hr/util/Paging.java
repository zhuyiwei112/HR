package com.hr.util;

import com.hr.model.Train;

import java.util.HashMap;
import java.util.List;

public class Paging {
    public static HashMap<String,Object> paging(List<?> list, Integer pageSize, Integer cp){
        int tp=0;
        if (cp==null){
            cp=1;
        }
        if (list!=null && list.size()!=0){
            tp= (int) Math.ceil(1.0*list.size()/pageSize);
            list=list.subList((cp-1)*pageSize,cp*pageSize>list.size()?list.size():cp*pageSize);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("tp",tp);
        return map;
    }
}
