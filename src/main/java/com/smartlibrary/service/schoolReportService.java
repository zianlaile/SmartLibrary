package com.smartlibrary.service;

import com.smartlibrary.dao.schoolReportDao;
import com.smartlibrary.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/10/17.
 */
@Service
public class schoolReportService {
    @Autowired
    private schoolReportDao schoolReportdao;

    //年度藏书文献总量
    public List<app_resources> getResourceCountBy_year(app_resources n){
        return schoolReportdao.getResourceCountBy_year(n);
    };
    //年度入馆总人次
    public  List<real_year_counts> getGctrlsCountBy_year(real_year_counts n){
        return schoolReportdao.getGctrlsCountBy_year(n);
    };
    //按月入馆人次
    public  List<gctrl> getGctrlsCountBy_month(gctrl n){
        return schoolReportdao.getGctrlsCountBy_month(n);
    };
    //年度借还总次数，借阅次数，还书次数
    public List<Book_Lend> getBook_LendCountBy_year(Book_Lend n){
        return schoolReportdao.getBook_LendCountBy_year(n);
    };
    //年度各学院借阅人次，还书人次
    public List<library_report_academy> getBook_LendCountBy_academyAndyear(library_report_academy n){
        return schoolReportdao.getBook_LendCountBy_academyAndyear(n);
    };
    //年度借阅人次前三学院名称
    public  List<library_report_academy> getLendTop3By_academyAndyear(library_report_academy n){
        return schoolReportdao.getLendTop3By_academyAndyear(n);
    };
    //年度人均借阅前3学院名称
    public  List<library_report_academy> getpreLendTop3By_academyAndyear(library_report_academy n){
        return schoolReportdao.getpreLendTop3By_academyAndyear(n);
    };
    //年度各学院借书比
    public  List<library_report_academy> getLendratioBy_academyAndyear(library_report_academy n){
        return schoolReportdao.getLendratioBy_academyAndyear(n);
    };
    //年度总借阅次数前十学生
    //年度总借阅次数前二十图书
    public  List<library_report_ranking_book> getop20bookBy_year(library_report_ranking_book n){
        return schoolReportdao.getop20bookBy_year(n);
    };
    //年度总借阅次数前二十著者
    public  List<library_report_ranking_author> getop20authorBy_year(library_report_ranking_author n){
        return schoolReportdao.getop20authorBy_year(n);
    };
    //年度在座时长统计
    public List<library_report_IC_duration> geICdurationBy_year(library_report_IC_duration n){
        return schoolReportdao.geICdurationBy_year(n);
    };
    //年度电子阅览室使用次数统计
    public  List<IC_Times> geICdurationCountBy_year(IC_Times n){
        return schoolReportdao.geICdurationCountBy_year(n);
    };
}
