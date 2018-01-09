package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.schoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/** 学校图书馆报告
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
    }
    //多年年度入馆总人次
    @RequestMapping(value = "/getGctrlsCountBy_year", method = RequestMethod.GET)
    public  List<real_year_counts> getGctrlsCountBy_year(){
        real_year_counts n=new real_year_counts();
        return schoolReportservice.getGctrlsCountBy_year(n);
    }
    //按月入馆人次
    @RequestMapping(value = "/getGctrlsCountBy_month", method = RequestMethod.GET)
    public  List<gctrl> getGctrlsCountBy_month(){
        gctrl n=new gctrl();
        return schoolReportservice.getGctrlsCountBy_month(n);
    }
    //年度借还总次数，借阅次数，还书次数
    @RequestMapping(value = "/getBook_LendCountBy_year", method = RequestMethod.GET)
    public List<Book_Lend> getBook_LendCountBy_year(){
        Book_Lend n=new Book_Lend();
        return schoolReportservice.getBook_LendCountBy_year(n);
    }
    //年度各学院借阅人次，还书人次
    @RequestMapping(value = "/getBook_LendCountBy_academyAndyear", method = RequestMethod.GET)
    public List<library_report_academy> getBook_LendCountBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getBook_LendCountBy_academyAndyear(n);
    }
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
    }
    //年度各学院借书比
    @RequestMapping(value = "/getLendratioBy_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getLendratioBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getLendratioBy_academyAndyear(n);
    }
    //年度总借阅次数前十学生
    //年度总借阅次数前二十图书
    @RequestMapping(value = "/getop20bookBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_book> getop20bookBy_year(){
        library_report_ranking_book n=new library_report_ranking_book();
        return schoolReportservice.getop20bookBy_year(n);
    }
    //年度总借阅次数前二十著者
    @RequestMapping(value = "/getop20authorBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_author> getop20authorBy_year(){
        library_report_ranking_author n=new library_report_ranking_author();
        return schoolReportservice.getop20authorBy_year(n);
    }
    //年度在座时长统计
    @RequestMapping(value = "/geICdurationBy_year", method = RequestMethod.GET)
    public List<library_report_IC_duration> geICdurationBy_year(){
        library_report_IC_duration n=new library_report_IC_duration();
        return schoolReportservice.geICdurationBy_year(n);
    }
    //年度电子阅览室使用次数统计
    @RequestMapping(value = "/geICdurationCountBy_year", method = RequestMethod.GET)
    public  List<IC_Times> geICdurationCountBy_year(){
        IC_Times n=new IC_Times();
        return schoolReportservice.geICdurationCountBy_year(n);
    }





    //<!--今年读者总借阅次数排名前10（包括学号、读者姓名、所属学院、总借阅次数）（表格）新表-学号-年份-->
    @RequestMapping(value = "/getReder_booklendCount_Byyear", method = RequestMethod.GET)
    public List<reader_report> getReder_booklendCount_Byyear(reader_report n){
        return schoolReportservice.getReder_booklendCount_Byyear(n);
    };
    //<!--年度设备平均使用次数统计-->
    @RequestMapping(value = "/getDeviceCount_Byhour", method = RequestMethod.GET)
    public  List<library_report_hour> getDeviceCount_Byhour(library_report_hour n){
        return schoolReportservice.getDeviceCount_Byhour(n);
    };
    //<!-- 年度各时段图书平均借出册数及人数（如8:00-9:00借出39册，21人借阅）（折线）-->
    @RequestMapping(value = "/getbooklendPeopleAndCount_Byhour", method = RequestMethod.GET)
    public  List<library_report_hour> getbooklendPeopleAndCount_Byhour(library_report_hour n){
        return schoolReportservice.getbooklendPeopleAndCount_Byhour(n);
    };
    // <!--年度全校读者借阅分类统计-->
    @RequestMapping(value = "/getBookkindAllCount_Byyear", method = RequestMethod.GET)
    public  List<Book_Lend> getBookkindAllCount_Byyear(Book_Lend n){
        return schoolReportservice.getBookkindAllCount_Byyear(n);
    };
    // <!--3. 有借阅记录的教职工读者人数-->
    @RequestMapping(value = "/getTeacherLendCount", method = RequestMethod.GET)
    List<Book_Lend> getTeacherLendCount(Book_Lend n){
        return schoolReportservice.getTeacherLendCount(n);
    };
    // < <!--教职工读者共借阅图书册数-->
    @RequestMapping(value = "/getTeacherLendCount_Byyear", method = RequestMethod.GET)
    List<Book_Lend> getTeacherLendCount_Byyear(Book_Lend n){
        return schoolReportservice.getTeacherLendCount_Byyear(n);
    };
    //<!--2011年-2017年教职工借阅人数统计（包括：<10册, 11-20册, 21-30册, 31-50册, 51-100册, 101-200册, 201-300册, >300册）（表格）
    // 做起来麻烦点 ，循环一下，lend，back 借用一下做大小值-->
    @RequestMapping(value = "/getTeacherCount_BycountAndyear", method = RequestMethod.GET)
    public Map<String, Object> getTeacherCount_BycountAndyear(library_report_month_mankinds n){
        return schoolReportservice.getTeacherCount_BycountAndyear(n);
    };
    // <!--  ?历年各大类图书借书比例趋势图（2011-2017年，包括：I文学、O数理化、F经济、TP计算机、K历史地理、B哲学宗教、D政治法律、H语言文字、其他）（折线图）（top5的类别数据）-->
    @RequestMapping(value = "/getTop5bookkind_Byyear", method = RequestMethod.GET)
    public   List<Book_Lend> getTop5bookkind_Byyear(Book_Lend n){
        return schoolReportservice.getTop5bookkind_Byyear(n);
    };
    /*<!--  6. 年度图书馆进馆读者类型比例（包括本科生、硕士生、教职工、其他）（饼图）
    7. 2011-2017年进馆读者类型比例趋势（包括本科生、硕士生、教职工、其他）
    8. 年度各类型读者借书比例（包括本科生、硕士生、教职工、其他）（柱状图）
    9. 年度各类型读者续借比例（包括本科生、硕士生、教职工、其他）（柱状图）-->*/
    @RequestMapping(value = "/getmankindCount_Byyear", method = RequestMethod.GET)
    public   List<library_report_month_mankinds> getmankindCount_Byyear(library_report_month_mankinds n){
        return schoolReportservice.getmankindCount_Byyear(n);
    }

    @RequestMapping(value = "/getmankindCount_Byoneyear", method = RequestMethod.GET)
    public   List<library_report_month_mankinds> getmankindCount_Byoneyear(library_report_month_mankinds n){
        return schoolReportservice.getmankindCount_Byoneyear(n);
    }
    @RequestMapping(value = "/gettypeprints",method = RequestMethod.GET)
    public Map<String,List> gettypeprints(){
        return schoolReportservice.gettypeprints();
    }





    //研修间-使用量分析（一年，四个类别(本科，研究生，教师，其他) ，四种IC资源）
    @RequestMapping(value = "/getICTimesBYTypeOneyear",method = RequestMethod.GET)
    public Map<String,List> getICTimesBYTypeOneyear(){
        IC_Times i=new IC_Times();
        return schoolReportservice.getICTimesBYTypeOneyear(i);
    }


    // <!--馆藏基本情况  总体情况 馆数量太多 取前十-->
    @RequestMapping(value = "/getCollectionOverall",method = RequestMethod.GET)
    public Map<String,List> getCollectionOverall(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionOverall(i);
    }
    //    <!--馆藏基本情况  当年新增情况 馆数量太多 取前十-->
    @RequestMapping(value = "/getCollectionNewAdded",method = RequestMethod.GET)
    public Map<String,List> getCollectionNewAdded(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionNewAdded(i);
    }

    //    <!--馆藏基本情况  新增馆藏分类分布 类别太多 取前十-->
    @RequestMapping(value = "/getCollectionNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionNewAddedByCate(i);
    }

    //    <!--馆藏基本情况  新增馆藏分类分布 类别太多 取前十-->
    @RequestMapping(value = "/getCollectionTuShuNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionTuShuNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionTuShuNewAddedByCate(i);
    }
    //    <!--馆藏基本情况  新增外文分类分布 类别太多 取前十-->
    @RequestMapping(value = "/getCollectionWaiWenNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionWaiWenNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionWaiWenNewAddedByCate(i);
    }

    //书目库书目记录总量
    @RequestMapping(value = "/getCollectionAmountType",method = RequestMethod.GET)
    public Map<String,List> getCollectionAmountType(){
        return schoolReportservice.getCollectionAmountType();
    }

    //书目库书目记录类型统计
    @RequestMapping(value = "/getCollectionByStackAndBooktype",method = RequestMethod.GET)
    public Map<String,List> getCollectionByStackAndBooktype(){
        return schoolReportservice.getCollectionByStackAndBooktype();
    }
    //图书按出版年份统计
    @RequestMapping(value = "/getCollectionByPubyear",method = RequestMethod.GET)
    public Map<String,CollectionBook> getCollectionByPubyear(){
        return  schoolReportservice.getCollectionByPubyear();
    }
    //各种格式书目分类分布（种）(册)
    @RequestMapping(value = "/getCollectionBycategory",method = RequestMethod.GET)
    public Map<String,List> getCollectionBycategory(){
        return schoolReportservice.getCollectionBycategory();
    }
    //品种前十的分类
    @RequestMapping(value = "/getTop10category",method = RequestMethod.GET)
    public Map<String,List> getTop10category(){
        return schoolReportservice.getTop10category();
    }
    //2011-2015 年每月上机人次折线图
    @RequestMapping(value = "/library_report_ic_total",method = RequestMethod.GET)
    public Map<Integer, Map<Integer, Integer>> getlibrary_report_ic_total(){ return schoolReportservice.library_report_ic_total();
    }
    // 2012-2015 年度全馆扫描 打复印统计
    @RequestMapping(value = "/library_report_add_times",method = RequestMethod.GET)
    public  Map<Integer,Map<String,Integer>> getlibrary_report_add_times(){ return schoolReportservice.library_report_add_times();
    }

}
