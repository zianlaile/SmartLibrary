package com.smartlibrary.dao2;

import com.smartlibrary.domain2.app_resources;

import java.util.List;

/**
 * Created by tt on 2017/9/25.
 */
public interface app_resourcesDao {
    Integer count(app_resources n);
    List<app_resources> showList(app_resources n);
    void add(app_resources adddate);
    void deletebyids(List ids);
    app_resources getbyid(int id);
    void update(app_resources data);
}
