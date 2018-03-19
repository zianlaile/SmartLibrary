package com.smartlibrary.service;

import com.smartlibrary.dao2.app_accountManagementDao;
import com.smartlibrary.domain2.app_accountManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class app_accountManagementService {
    @Autowired
    public app_accountManagementDao app_accountmanagementdao;

    public void add(app_accountManagement adddate){
        app_accountmanagementdao.add(adddate);
    }
}
