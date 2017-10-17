package com.smartlibrary.dao;

import com.smartlibrary.domain.*;

import java.util.List;

/**
 * Created by tt on 2017/10/17.
 */
public interface schoolReportDao {
    //年度藏书文献总量
    List<app_resources> getResourceCountBy_year(app_resources n);
    //年度入馆总人次
    List<real_year_counts> getGctrlsCountBy_year(real_year_counts n);
    //按月入馆人次
    List<gctrl> getGctrlsCountBy_month(gctrl n);
    //年度借还总次数，借阅次数，还书次数
    List<Book_Lend> getBook_LendCountBy_year(Book_Lend n);
    //年度各学院借阅人次，还书人次
    List<library_report_academy> getBook_LendCountBy_academyAndyear(library_report_academy n);
    //年度借阅人次前三学院名称
    List<library_report_academy> getLendTop3By_academyAndyear(library_report_academy n);
    //年度人均借阅前3学院名称
    List<library_report_academy> getpreLendTop3By_academyAndyear(library_report_academy n);
    //年度各学院借书比
    List<library_report_academy> getLendratioBy_academyAndyear(library_report_academy n);
    //年度总借阅次数前十学生
    //年度总借阅次数前二十图书
    List<library_report_ranking_book> getop20bookBy_year(library_report_ranking_book n);
    //年度总借阅次数前二十著者
    List<library_report_ranking_author> getop20authorBy_year(library_report_ranking_author n);
    //年度在座时长统计
    List<library_report_IC_duration> geICdurationBy_year(library_report_IC_duration n);
    //年度电子阅览室使用次数统计
    List<IC_Times> geICdurationCountBy_year(IC_Times n);

}
