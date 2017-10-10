package com.smartlibrary.dao;

import com.smartlibrary.domain.app_employee;

import java.util.List;

/**
 * Created by tt on 2017/9/25.
 */
public interface app_employeeDao {
    Integer count(app_employee n);
    List<app_employee> showList(app_employee n);
    void add(app_employee adddate);
    void deletebyids(List ids);
    app_employee getbyid(int id);
    void update(app_employee data);
}
