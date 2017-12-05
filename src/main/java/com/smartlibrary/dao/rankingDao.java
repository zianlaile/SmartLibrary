package com.smartlibrary.dao;

import com.smartlibrary.domain.ranking;

import java.util.List;

/**
 * Created by tt on 2017/12/4.
 */
public interface rankingDao {
    //历年借阅图书排行
    List<ranking> getranking_lend_book_year(ranking b);
    //历年最多借阅读者排行
    List<ranking> getranking_lend_reader_year(ranking b);
    //学院借阅图书排行
    List<ranking> getranking_lend_academy_book_year(ranking b);
    //学院最多借阅读者排行
    List<ranking> getranking_lend_academy_reader_year(ranking b);
    //总量月进馆量排行
    List<ranking> getranking_gctrl_month(ranking b);
    //总量日进馆量排行
    List<ranking> getranking_gctrl_day(ranking b);
    //学院月进馆量排行
    List<ranking> getranking_gctrl_academy_month(ranking b);
    //学院日进馆量排行
    List<ranking> geranking_gctrl_academy_day(ranking b);
    //打印机使用排行
    List<ranking> getranking_print_year(ranking b);
    
}
