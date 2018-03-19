package com.smartlibrary.dao2;

import com.smartlibrary.domain2.app_accountManagement;

import java.util.List;

public interface app_accountManagementDao {
    void add(app_accountManagement adddate);
    Integer count(app_accountManagement n);
    List<app_accountManagement> showList(app_accountManagement n);
}
