package com.smartlibrary.dao;

import com.smartlibrary.domain2.app_notice;

import java.util.List;

/**
 * Created by tt on 2017/10/18.
 */
public interface bigScreenNoticeDao {
    Integer count(app_notice n);
    List<app_notice> showList(app_notice n);
    void add(app_notice adddate);
    void deletebyids(List ids);
    app_notice getbyid(int id);
    void update(app_notice data);
    app_notice getnew() ;
}
