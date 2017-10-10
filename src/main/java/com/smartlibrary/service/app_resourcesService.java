package com.smartlibrary.service;

import com.smartlibrary.dao.app_resourcesDao;
import com.smartlibrary.domain.app_resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/9/25.
 */
@Service
public class app_resourcesService {
    @Autowired
    private app_resourcesDao app_resourcesdao;

    public Integer Count(app_resources r){
        return app_resourcesdao.count(r);
    }

    public List<app_resources> ShowList(app_resources r){
        return app_resourcesdao.showList(r);
    }
    public void add(app_resources adddate){
        app_resourcesdao.add(adddate);
    }

    public void deletebyids(List ids){
        app_resourcesdao.deletebyids(ids);
    }

    public app_resources getbyid(int id){
        return app_resourcesdao.getbyid(id);
    }
    public void update(app_resources data){
        app_resourcesdao.update(data);
    }
}
