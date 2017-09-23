package com.smartlibrary.dao2;

import com.smartlibrary.domain2.app_book_suggest;

import java.util.List;

/**
 * Created by tt on 2017/9/22.
 */
public interface book_suggestDao {
    Integer count(app_book_suggest bs);
    List<app_book_suggest> showList(app_book_suggest bs);
    void addbs(app_book_suggest adddate);
    void deletebyids(List ids);
    app_book_suggest getbsbyid(int id);
     void updatebs(app_book_suggest data);
}
