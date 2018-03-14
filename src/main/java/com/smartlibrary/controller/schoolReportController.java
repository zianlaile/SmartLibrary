package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.schoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    //37. 返回每年藏书文献总量
    @RequestMapping(value = "/getResourceCountBy_year", method = RequestMethod.GET)
    public List<app_resources> getResourceCountBy_year(){
        app_resources n=new app_resources();
        return schoolReportservice.getResourceCountBy_year(n);
    }
    //38. 返回每年入馆总人次
    @RequestMapping(value = "/getGctrlsCountBy_year", method = RequestMethod.GET)
    public  List<real_year_counts> getGctrlsCountBy_year(){
        real_year_counts n=new real_year_counts();
        return schoolReportservice.getGctrlsCountBy_year(n);
    }
    //39. 返回今年每月入馆总人次
    @RequestMapping(value = "/getGctrlsCountBy_month", method = RequestMethod.GET)
    public  List<gctrl> getGctrlsCountBy_month(){
        gctrl n=new gctrl();
        return schoolReportservice.getGctrlsCountBy_month(n);
    }
    //5.返回历年全馆图书借还总次数
    @RequestMapping(value = "/getBook_LendCountBy_year", method = RequestMethod.GET)
    public List<Book_Lend> getBook_LendCountBy_year(){
        Book_Lend n=new Book_Lend();
        return schoolReportservice.getBook_LendCountBy_year(n);
    }
    //8.年度各学院借阅人次，还书人次
    @RequestMapping(value = "/getBook_LendCountBy_academyAndyear", method = RequestMethod.GET)
    public List<library_report_academy> getBook_LendCountBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getBook_LendCountBy_academyAndyear(n);
    }
    //40. 返回今年借阅人次前三学院名称，及借阅次数
    @RequestMapping(value = "/getLendTop3By_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getLendTop3By_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getLendTop3By_academyAndyear(n);
    };
    //41. 返回今年人均借阅前三学院名称，及借阅次数
    @RequestMapping(value = "/getpreLendTop3By_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getpreLendTop3By_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getpreLendTop3By_academyAndyear(n);
    }
    //42. 返回今年各学院人均借阅次数
    @RequestMapping(value = "/getLendratioBy_academyAndyear", method = RequestMethod.GET)
    public  List<library_report_academy> getLendratioBy_academyAndyear(){
        library_report_academy n=new library_report_academy();
        return schoolReportservice.getLendratioBy_academyAndyear(n);
    }
    //年度总借阅次数前十学生
    //43. 返回今年总借阅次数前二十图书
    @RequestMapping(value = "/getop20bookBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_book> getop20bookBy_year(){
        library_report_ranking_book n=new library_report_ranking_book();
        return schoolReportservice.getop20bookBy_year(n);
    }
    //44. 返回今年总借阅次数前二十著者
    @RequestMapping(value = "/getop20authorBy_year", method = RequestMethod.GET)
    public  List<library_report_ranking_author> getop20authorBy_year(){
        library_report_ranking_author n=new library_report_ranking_author();
        return schoolReportservice.getop20authorBy_year(n);
    }
    //45. 返回今年在座时长统计
    @RequestMapping(value = "/geICdurationBy_year", method = RequestMethod.GET)
    public List<library_report_IC_duration> geICdurationBy_year(){
        library_report_IC_duration n=new library_report_IC_duration();
        return schoolReportservice.geICdurationBy_year(n);
    }
    //46. 返回今年每月电子阅览室使用次数统计
    @RequestMapping(value = "/geICdurationCountBy_year", method = RequestMethod.GET)
    public  List<IC_Times> geICdurationCountBy_year(){
        IC_Times n=new IC_Times();
        return schoolReportservice.geICdurationCountBy_year(n);
    }

    //47. 返回今年读者总借阅次数排名前10
    @RequestMapping(value = "/getReder_booklendCount_Byyear", method = RequestMethod.GET)
    public List<reader_report> getReder_booklendCount_Byyear(reader_report n){
        return schoolReportservice.getReder_booklendCount_Byyear(n);
    };
    //48. 返回今年设备使用次数统计
    @RequestMapping(value = "/getDeviceCount_Byhour", method = RequestMethod.GET)
    public  List<library_report_hour> getDeviceCount_Byhour(library_report_hour n){
        return schoolReportservice.getDeviceCount_Byhour(n);
    };
    //<!-- 年度各时段图书平均借出册数及人数（如8:00-9:00借出39册，21人借阅）（折线）-->
    //4.返回当年各时段图书平均借出册数及人数
    @RequestMapping(value = "/getbooklendPeopleAndCount_Byhour", method = RequestMethod.GET)
    public  List<library_report_hour> getbooklendPeopleAndCount_Byhour(library_report_hour n){
        return schoolReportservice.getbooklendPeopleAndCount_Byhour(n);
    };
    // <!--年度全校读者借阅分类统计-->
    //11.返回今年各图书种类借阅总数
    @RequestMapping(value = "/getBookkindAllCount_Byyear", method = RequestMethod.GET)
    public  List<Book_Lend> getBookkindAllCount_Byyear(Book_Lend n){
        return schoolReportservice.getBookkindAllCount_Byyear(n);
    };
    // 49. 返回今年有借阅记录的教职工读者人数
    @RequestMapping(value = "/getTeacherLendCount", method = RequestMethod.GET)
    List<Book_Lend> getTeacherLendCount(Book_Lend n){
        return schoolReportservice.getTeacherLendCount(n);
    };
    // 50. 返回历年有借阅记录的教职工读者人数
    @RequestMapping(value = "/getTeacherLendCount_Byyear", method = RequestMethod.GET)
    List<Book_Lend> getTeacherLendCount_Byyear(Book_Lend n){
        return schoolReportservice.getTeacherLendCount_Byyear(n);
    };
    //51. 返回历年教职工借阅人数统计（包括：<10册, 11-20册, 21-30册, 31-50册, 51-100册, 101-200册, 201-300册, >300册）
    // 做起来麻烦点 ，循环一下，lend，back 借用一下做大小值-->
    @RequestMapping(value = "/getTeacherCount_BycountAndyear", method = RequestMethod.GET)
    public Map<String, Object> getTeacherCount_BycountAndyear(library_report_month_mankinds n){
        return schoolReportservice.getTeacherCount_BycountAndyear(n);
    };
   //13.返回历年各类型图书借阅top5总数
    @RequestMapping(value = "/getTop5bookkind_Byyear", method = RequestMethod.GET)
    public   List<Book_Lend> getTop5bookkind_Byyear(Book_Lend n){
        return schoolReportservice.getTop5bookkind_Byyear(n);
    };
    /*<!--年度图书馆进馆读者类型比例（包括本科生、硕士生、教职工、其他）（饼图）
   2011-2017年进馆读者类型比例趋势（包括本科生、硕士生、教职工、其他）
   年度各类型读者借书比例（包括本科生、硕士生、教职工、其他）（柱状图）
   年度各类型读者续借比例（包括本科生、硕士生、教职工、其他）（柱状图）-->*/
    //18.返回历年各类型读者各借阅，续借，进馆总数
    @RequestMapping(value = "/getmankindCount_Byyear", method = RequestMethod.GET)
    public   List<library_report_month_mankinds> getmankindCount_Byyear(library_report_month_mankinds n){
        return schoolReportservice.getmankindCount_Byyear(n);
    }
    //12.返回今年各类型读者各借阅，续借，进馆总数
    @RequestMapping(value = "/getmankindCount_Byoneyear", method = RequestMethod.GET)
    public   List<library_report_month_mankinds> getmankindCount_Byoneyear(library_report_month_mankinds n){
        return schoolReportservice.getmankindCount_Byoneyear(n);
    }
    //52. 返回历年各类型打印次数
    @RequestMapping(value = "/gettypeprints",method = RequestMethod.GET)
    public Map<String,List> gettypeprints(){
        return schoolReportservice.gettypeprints();
    }

    //53. 返回历年各类型打印数量
    @RequestMapping(value = "/gettypeprintsamount",method = RequestMethod.GET)
    public Map<String,List> gettypeprintsamount(){
        return schoolReportservice.gettypeprintsamount();
    }

    //54. 今年四个类别(本科，研究生，教师，其他)的人每月研修间使用量
    @RequestMapping(value = "/getICTimesBYTypeOneyear",method = RequestMethod.GET)
    public Map<String,List> getICTimesBYTypeOneyear(){
        IC_Times i=new IC_Times();
        return schoolReportservice.getICTimesBYTypeOneyear(i);
    }

    // <!--馆藏基本情况  总体情况 馆数量太多 取前十-->
    //32. 返回图书馆各馆藏总量排行top10
    @RequestMapping(value = "/getCollectionOverall",method = RequestMethod.GET)
    public Map<String,List> getCollectionOverall(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionOverall(i);
    }
    //    <!--馆藏基本情况  当年新增情况 馆数量太多 取前十-->
    ///33. 返回图书馆各馆藏今年新增量排行top10
    @RequestMapping(value = "/getCollectionNewAdded",method = RequestMethod.GET)
    public Map<String,List> getCollectionNewAdded(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionNewAdded(i);
    }

    //    <!--馆藏基本情况  新增馆藏分类分布 类别太多 取前十-->
    //34 返回今年图书馆馆藏新增各分类排行top10
    @RequestMapping(value = "/getCollectionNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionNewAddedByCate(i);
    }

    //    <!--馆藏基本情况  新增馆藏分类分布 类别太多 取前十-->
    //35. 返回今年图书馆图书的馆藏新增各分类排行top10
    @RequestMapping(value = "/getCollectionTuShuNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionTuShuNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionTuShuNewAddedByCate(i);
    }
    //    <!--馆藏基本情况  新增外文分类分布 类别太多 取前十-->
    //35. 返回今年图书馆外文的馆藏新增各分类排行top10
    @RequestMapping(value = "/getCollectionWaiWenNewAddedByCate",method = RequestMethod.GET)
    public Map<String,List> getCollectionWaiWenNewAddedByCate(){
        CollectionBook i=new CollectionBook();
        return schoolReportservice.getCollectionWaiWenNewAddedByCate(i);
    }

    //书目库书目记录总量  // 目前方法报错 暂时注释
    @RequestMapping(value = "/getCollectionAmountType",method = RequestMethod.GET)
    public Map<String,List> getCollectionAmountType(HttpServletRequest year){
        return schoolReportservice.getCollectionAmountType(year.getQueryString());
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
    //2015-2017 年每月上机人次折线图
    @RequestMapping(value = "/library_report_ic_total",method = RequestMethod.GET)
    public Map<Integer, Map<Integer, Integer>> getlibrary_report_ic_total(){ return schoolReportservice.library_report_ic_total();
    }
    // 2015-2017 年度全馆扫描 打复印统计
    @RequestMapping(value = "/library_report_add_times", method = RequestMethod.GET)
    public List<library_report_month_mankinds> getlibrary_report_add_times(library_report_month_mankinds n){ return schoolReportservice.getlibrary_report_add_times(n);
    }

    // 学院借阅前三
    @RequestMapping(value = "/getYearTop3CategoryByAcademy", method = RequestMethod.GET)
    public Map<Integer,Map<String,List>> getYearTop3CategoryByAcademy(){ return schoolReportservice.getYearTop3CategoryByAcademy(); }
    //  外接前100 的书本
    @RequestMapping(value = "/getSingleBookLendTop100", method = RequestMethod.GET)
    public Map<String,List> getSingleBookLendTop100(){ return schoolReportservice.getSingleBookLendTop100();
    }
    //  2015-2017 年各类型读者入馆总人次统计
    @RequestMapping(value = "/library_report_identity_sum", method = RequestMethod.GET)
    public Map<String,List> getlibrary_report_identity_sum(){ return schoolReportservice.getlibrary_report_identity_sum();
    }
    // 2015-2017年度全馆各地点自助扫描、打复印统计详表
    @RequestMapping(value = "/getLibraryTypeTimes", method = RequestMethod.GET)
    public List<String[][]> getLibraryTypeTimes (HttpServletRequest year) { return schoolReportservice.getlibraryTypeTimes(year.getQueryString());
    }
    // 年度研究生接借书最受欢迎的前十
    @RequestMapping(value = "/getLibraryReportGeneralRankingTop10InGraduate", method = RequestMethod.GET)
    public List<library_report_ranking_book> getLibraryReportGeneralRankingTop10InGraduate(library_report_ranking_book n){
        return schoolReportservice.getLibraryReportGeneralRankingTop10InGraduate(n); }
    // 年度本科生接借书最受欢迎的前十
    @RequestMapping(value = "/getLibraryReportGeneralRankingTop10InUndergraduate", method = RequestMethod.GET)
    public List<library_report_ranking_book> getLibraryReportGeneralRankingTop10InUndergraduate(library_report_ranking_book n){
        return schoolReportservice.getLibraryReportGeneralRankingTop10InUndergraduate(n); }
    // 本科生分类排行
    @RequestMapping(value = "/getLibraryClassifyRankInUndergraduate", method = RequestMethod.GET)
    public  Map<String,ArrayList<library_report_ranking_book>> getLibraryClassifyRankInUndergraduate(library_report_ranking_book n){
        return schoolReportservice.getLibraryClassifyRankInUndergraduate(n); }
    // 研究生分类排行
    @RequestMapping(value = "/getLibraryClassifyRankInGraduate", method = RequestMethod.GET)
    public Map<String,ArrayList<library_report_ranking_book>> getLibraryClassifyRankInGraduate(library_report_ranking_book n){
        return schoolReportservice.getLibraryClassifyRankInGraduate(n); }
    @RequestMapping(value = "/getDailyLendPeopleAndCount", method = RequestMethod.GET)
    public Map<String,List> getDailyLendPeopleAndCount(){ return schoolReportservice.getDailyLendPeopleAndCount();}
    //各时段流通情况（册）
    @RequestMapping(value = "/getCirculationByHour", method = RequestMethod.GET)
    public Map<String,List> getCirculationByHour(){ return schoolReportservice.getCirculationByHour();}
    //年度各学院本科生借阅情况
    @RequestMapping(value = "/getUndergraduateBorrowingSituation", method = RequestMethod.GET)
    public List<library_report_lend_condition> getUndergraduateBorrowingSituation(library_report_lend_condition n){ return schoolReportservice.getUndergraduateBorrowingSituation(n);}
    //年度各学院研究生借阅情况
    @RequestMapping(value = "/getGraduateBorrowingSituation", method = RequestMethod.GET)
    public List<library_report_lend_condition> getGraduateBorrowingSituation(library_report_lend_condition n){ return schoolReportservice.getGraduateBorrowingSituation(n);}
    //年度人均借阅量
    @RequestMapping(value = "/getPerCapitaBorrowingAmount", method = RequestMethod.GET)
    public List<library_report_lend_condition> getPerCapitaBorrowingAmount(library_report_lend_condition n){ return schoolReportservice.getPerCapitaBorrowingAmount(n);}
    //年度各学院本科生人均借阅量
    @RequestMapping(value = "/getUndergraduatePerCapitaBorrowingAmount", method = RequestMethod.GET)
    public List<library_report_lend_condition> getUndergraduatePerCapitaBorrowingAmount(library_report_lend_condition n){ return schoolReportservice.getUndergraduatePerCapitaBorrowingAmount(n);}
    //年度各学院研究生人均借阅量
    @RequestMapping(value = "/getGraduatePerCapitaBorrowingAmount", method = RequestMethod.GET)
    public List<library_report_lend_condition> getGraduatePerCapitaBorrowingAmount(library_report_lend_condition n){ return schoolReportservice.getGraduatePerCapitaBorrowingAmount(n);}
    //本科生借阅量年度对比
    @RequestMapping(value = "/getUndergraduateAnnualComparisonofBorrowings", method = RequestMethod.GET)
    public List<library_report_lend_condition> getUndergraduateAnnualComparisonofBorrowings(library_report_lend_condition n){ return schoolReportservice.getUndergraduateAnnualComparisonofBorrowings(n);}
    //研究生借阅量年度对比
    @RequestMapping(value = "/getGraduateAnnualComparisonofBorrowings", method = RequestMethod.GET)
    public List<library_report_lend_condition> getGraduateAnnualComparisonofBorrowings(library_report_lend_condition n){ return schoolReportservice.getGraduateAnnualComparisonofBorrowings(n);}


}





