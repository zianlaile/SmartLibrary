package com.smartlibrary.service;

import com.smartlibrary.dao2.app_accountManagementDao;
import com.smartlibrary.domain2.app_accountManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class app_accountManagementService {
    @Autowired
    public app_accountManagementDao app_accountmanagementdao;

    public void add(app_accountManagement adddate){
        app_accountmanagementdao.add(adddate);
    }

    public List<app_accountManagement> showList(app_accountManagement n) { return  app_accountmanagementdao.showList(n); }
    public Integer Count(app_accountManagement r){
        return app_accountmanagementdao.count(r);
    }

}
