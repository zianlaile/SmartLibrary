package com.smartlibrary.service;

import com.smartlibrary.dao.app_employeeDao;
import com.smartlibrary.domain.app_employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/9/25.
 */
@Service
public class app_employeeService {
    @Autowired
    private app_employeeDao app_employeedao;

    public Integer Count(app_employee r){
        return app_employeedao.count(r);
    }

    public List<app_employee> ShowList(app_employee r){
        return app_employeedao.showList(r);
    }
    public void add(app_employee adddate){
        app_employeedao.add(adddate);
    }
    public void deletebyids(List ids){
        app_employeedao.deletebyids(ids);
    }

    public app_employee getbyid(int id){
        return app_employeedao.getbyid(id);
    }
    public void update(app_employee data){
        app_employeedao.update(data);
    }
}
