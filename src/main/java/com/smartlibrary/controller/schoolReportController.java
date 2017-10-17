package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.schoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tt on 2017/10/17.
 */
@RestController
@RequestMapping({ "/schoolReport" })
public class schoolReportController {
    @Autowired
    private schoolReportService schoolReportservice;
    //年度藏书文献总量
    @RequestMapping(value = "/getResourceCountBy_year", method = RequestMethod.GET)
    public List<app_resources> getResourceCountBy_year(){
        app_resources n=new app_resources();
        return schoolReportservice.getResourceCountBy_year(n);
    };
    //年度入馆总人次
    @RequestMapping(value = "/getGctrlsCountBy_year", method = RequestMethod.GET)
    public  List<real_year_counts> getGctrlsCountBy_year(){
        real_year_counts n=new real_year_counts();
        return schoolReportservice.getGctrlsCountBy_year(n);
    };
    //按月入馆人次
    @RequestMapping(value = "/getGctrlsCountBy_month", method = RequestMethod.GET)
    public  List<gctrl> getGctrlsCountBy_month(){
        gctrl n=new gctrl();
        return schoolReportservice.getGctrlsCountBy_month(n);
    };
    //年度借还总次数，借阅次数，还书次数
    @RequestMapping(value = "/getBook_LendCountBy_year", method = RequestMethod.GET)
    public List<Book_Lend> getBook_LendCountBy_year(){
        Book_Lend n=new Book_Lend();
        return schoolReportservice.getBook_LendCountBy_year(n);
    };
    //年度各学院借阅人次，还书人次
    @RequestMapping(value = "/getBook_LendCountBy_academyAndyear", method = RequestMethod.GET)
    public List<library_report_academy> getBook_LendCountBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getBook_LendCountBy_academyAndyear(n);
    };
    //年度借阅人次前三学院名称
    @RequestMapping(value = "/getLendTop3By_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getLendTop3By_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getLendTop3By_academyAndyear(n);
    };
    //年度人均借阅前3学院名称
    @RequestMapping(value = "/getpreLendTop3By_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getpreLendTop3By_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getpreLendTop3By_academyAndyear(n);
    };
    //年度各学院借书比
    @RequestMapping(value = "/getLendratioBy_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getLendratioBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getLendratioBy_academyAndyear(n);
    };
    //年度总借阅次数前十学生
    //年度总借阅次数前二十图书
    @RequestMapping(value = "/getop20bookBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_book> getop20bookBy_year(){
        library_report_ranking_book n=new library_report_ranking_book();
        return schoolReportservice.getop20bookBy_year(n);
    };
    //年度总借阅次数前二十著者
    @RequestMapping(value = "/getop20authorBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_author> getop20authorBy_year(){
        library_report_ranking_author n=new library_report_ranking_author();
        return schoolReportservice.getop20authorBy_year(n);
    };
    //年度在座时长统计
    @RequestMapping(value = "/geICdurationBy_year", method = RequestMethod.GET)
    public List<library_report_IC_duration> geICdurationBy_year(){
        library_report_IC_duration n=new library_report_IC_duration();
        return schoolReportservice.geICdurationBy_year(n);
    };
    //年度电子阅览室使用次数统计
    @RequestMapping(value = "/geICdurationCountBy_year", method = RequestMethod.GET)
    public  List<IC_Times> geICdurationCountBy_year(){
        IC_Times n=new IC_Times();
        return schoolReportservice.geICdurationCountBy_year(n);
    };
}
