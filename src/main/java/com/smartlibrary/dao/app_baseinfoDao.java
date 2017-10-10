package com.smartlibrary.dao;

import com.smartlibrary.domain.app_baseinfo;

import java.util.List;

/**
 * Created by tt on 2017/10/10.
 */
public interface app_baseinfoDao {
    Integer count(app_baseinfo n);
    List<app_baseinfo> showList(app_baseinfo n);
    void add(app_baseinfo adddate);
    void deletebyids(List ids);
    app_baseinfo getbyid(int id);
    void update(app_baseinfo data);
}
