package com.smartlibrary.service;

import com.smartlibrary.dao.app_baseinfoDao;
import com.smartlibrary.domain.app_baseinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/10/10.
 */
@Service
public class app_baseinfoService {
    @Autowired
    private app_baseinfoDao app_baseinfodao;

    public Integer Count(app_baseinfo r){
        return app_baseinfodao.count(r);
    }

    public List<app_baseinfo> ShowList(app_baseinfo r){
        return app_baseinfodao.showList(r);
    }
    public void add(app_baseinfo adddate){
        app_baseinfodao.add(adddate);
    }

    public void deletebyids(List ids){
        app_baseinfodao.deletebyids(ids);
    }

    public app_baseinfo getbyid(int id){
        return app_baseinfodao.getbyid(id);
    }
    public void update(app_baseinfo data){
        app_baseinfodao.update(data);
    }
}
