package com.smartlibrary.controller;

import com.smartlibrary.domain.reader_report;
import com.smartlibrary.service.readerReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tt on 2017/11/13.
 */
@RestController
@RequestMapping({ "/readerReport" })
public class readerReportController {
    @Autowired
    private readerReportService readerReportservice;

    //   <!-- 1. 读者姓名、学院、身份-->
    @RequestMapping(value = "/getReaderInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderInfo(n);
    }
    // <!-- 读者第一次进馆时间、累计进馆次数、到馆次数超过校友百分比（例如：超过87%的校友）-->
    @RequestMapping(value = "/getReaderGctrlInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderGctrlInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderGctrlInfo(n);
    }
    //<!-- 读者借阅时间最长的书名及借阅天数、借书总量、借书量排名（如: 排名第87位）-->
    @RequestMapping(value = "/getReaderBookLendInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderBookLendInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderBookLendInfo(n);
    }
    //<!-- 借书最多的书籍类别及借阅该类别书籍的总量（如：文学类，共借阅212本），借阅图书最多的月份及该月借阅数量，借阅各类别图书所占百分比（如：经济42%，外语7%…）-->
    @RequestMapping(value = "/getReaderMaxBookLendInfo", method = RequestMethod.POST)
    public  List<reader_report> getReaderMaxBookLendInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderMaxBookLendInfo(n);

    }
    // <!-- 打印页数最多文件的页数及日期、累计文印总量、文印总量排名百分比、文印各类别数量-->
    @RequestMapping(value = "/getReaderprintInfo", method = RequestMethod.POST)
    public  List<reader_report> getReaderprintInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderprintInfo(n);

    }
    //<!-- 座位使用时间最长时长及日期（如：2015年9月16日使用座位4小时）、座位使用总次数、研修间使用总时长-->
    @RequestMapping(value = "/getReaderDeviceHourInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderDeviceHourInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderDeviceHourInfo(n);

    }

    // <!-- 每年座位及研修间使用总时长-->
    @RequestMapping(value = "/getReaderSeatandcroomInfo", method = RequestMethod.POST)
    public List<reader_report> getReaderSeatandcroomInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderSeatandcroomInfo(n);

    };
    // <!-- 电子阅览室使用时间最长时长及日期、电子阅览室使用总次数、使用总时长-->
    @RequestMapping(value = "/getReaderEreadHourInfo", method = RequestMethod.POST)
    public   List<reader_report> getReaderEreadHourInfo(reader_report n){
        //n.setAccount("20092476");
        return readerReportservice.getReaderEreadHourInfo(n);

    }

}
