package com.smartlibrary.controller;

import com.smartlibrary.domain.reader_report;
import com.smartlibrary.service.readerReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tt on 2017/11/13.
 */
@RestController
@RequestMapping({ "/readerReport" })
public class readerReportController {
    @Autowired
    private readerReportService readerReportservice;

    //55. 返回读者姓名、学院、身份
    @RequestMapping(value = "/getReaderInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderInfo(@RequestBody  reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderInfo(n);
    }
    // 56. 返回读者第一次进馆时间、累计进馆次数、到馆次数超过校友百分比
    @RequestMapping(value = "/getReaderGctrlInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderGctrlInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderGctrlInfo(n);
    }
    //57. 返回读者借阅时间最长的书名及借阅天数、借书总量、借书量排名
    @RequestMapping(value = "/getReaderBookLendInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderBookLendInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderBookLendInfo(n);
    }
    //<!-- 借书最多的书籍类别及借阅该类别书籍的总量（如：文学类，共借阅212本），借阅图书最多的月份及该月借阅数量，借阅各类别图书所占百分比（如：经济42%，外语7%…）-->
    //58. 返回读者借书最多的书籍类别及借阅该类别书籍的总量（如：文学类，共借阅212本），借阅图书最多的月份及该月借阅数量
    @RequestMapping(value = "/getReaderMaxBookLendInfo", method = RequestMethod.POST)
    public  List<reader_report> getReaderMaxBookLendInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderMaxBookLendInfo(n);

    }
    // <!-- 打印页数最多文件的页数及日期、累计文印总量、文印总量排名百分比、文印各类别数量-->
    //59. 返回读者打印页数最多文件的页数及日期
    @RequestMapping(value = "/getReaderprintInfo", method = RequestMethod.POST)
    public  List<reader_report> getReaderprintInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderprintInfo(n);

    }
    //<!-- 座位使用时间最长时长及日期（如：2015年9月16日使用座位4小时）、座位使用总次数、研修间使用总时长-->
    //60. 返回读者座位使用时间最长时长及日期（如：2015年9月16日使用座位4小时）、座位使用总次数、研修间使用总时长
    @RequestMapping(value = "/getReaderDeviceHourInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderDeviceHourInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderDeviceHourInfo(n);

    }

    // <!-- 每年座位及研修间使用总时长-->
    //61. 返回读者每年座位及研修间使用总时长
    @RequestMapping(value = "/getReaderSeatandcroomInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderSeatandcroomInfo(@RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderSeatandcroomInfo(n);

    }


    // <!-- 电子阅览室使用时间最长时长及日期、电子阅览室使用总次数、使用总时长-->
    //62. 返回读者电子阅览室使用时间最长时长及日期、电子阅览室使用总次数、使用总时长
    @RequestMapping(value = "/getReaderEreadHourInfo", method = RequestMethod.POST)
    public   List<reader_report> getReaderEreadHourInfo( @RequestBody reader_report n){
      //n.setAccount("20092476");
        return readerReportservice.getReaderEreadHourInfo(n);

    }

    //<!-- 借阅图书使用时间最长书名、时长,传学号，年份-->
    //63. 返回读者借阅图书使用时间最长书名、时长
    @RequestMapping(value = "/getReaderlonggest_book_name_and_days", method = RequestMethod.POST)
    public List<reader_report> getReaderlonggest_book_name_and_days(@RequestBody reader_report n){
        return readerReportservice.getReaderlonggest_book_name_and_days(n);
    }





    //  <!-- app需要 全校进馆 借阅排名-->
    @RequestMapping(value = "/getapp_bookandgctrl_rank", method = RequestMethod.POST)
    public   List<reader_report> getapp_bookandgctrl_rank(@RequestBody   reader_report n){
        return readerReportservice.getapp_bookandgctrl_rank(n);

    }


    //<!-- 借阅图书使用时间最长书名、时长,传学号，年份-->
    @RequestMapping(value = "/getReaderlonggest_book_name_and_days", method = RequestMethod.POST)
    public List<reader_report> getReaderlonggest_book_name_and_days(@RequestBody reader_report n){
        return readerReportservice.getReaderlonggest_book_name_and_days(n);
    }


    //<!-- app需要 学院进馆排名-->
    @RequestMapping(value = "/getapp_gctrl_academy_rank", method = RequestMethod.POST)
    public  Integer getapp_gctrl_academy_rank(@RequestBody   reader_report n){
        return readerReportservice.getapp_gctrl_academy_rank(n);

    }
    // <!-- app需要 学院借阅排名-->
    @RequestMapping(value = "/getapp_book_academy_rank", method = RequestMethod.POST)
    public  Integer getapp_book_academy_rank(@RequestBody  reader_report n){
        return readerReportservice.getapp_book_academy_rank(n);

    }
    // <!-- app需要 学院借阅排名-->
    @RequestMapping(value = "/getapp_all_rank", method = RequestMethod.GET)
    public   List<reader_report> getapp_all_rank(@RequestParam("account") String account){
        System.out.println(account);
        System.out.println(123);
        reader_report n=new reader_report ();
        n.setAccount(account);
        List<reader_report> a=readerReportservice.getapp_bookandgctrl_rank(n);
        if(a.size()==0)return null;
        a.get(0).setMonth_gctrl_rank(readerReportservice.getapp_gctrl_academy_rank(n));
        a.get(0).setMonth_lend_rank(readerReportservice.getapp_book_academy_rank(n));
        return a;

    }

}
