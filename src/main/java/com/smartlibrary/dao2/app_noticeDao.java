package com.smartlibrary.dao2;

import com.smartlibrary.domain2.app_notice;

import java.util.List;

/**
 * Created by tt on 2017/9/23.
 */
public interface app_noticeDao {
    Integer count(app_notice n);
    List<app_notice> showList(app_notice n);
    void addn(app_notice adddate);
    void deletebyids(List ids);
    app_notice getnbyid(int id);
    void updaten(app_notice data);
    void updaten_picurl(app_notice data);

}
