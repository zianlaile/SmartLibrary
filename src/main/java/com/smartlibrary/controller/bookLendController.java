package com.smartlibrary.controller;

import com.smartlibrary.domain.Book_Lend;
import com.smartlibrary.service.bookLendService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/7/17.
 */
@Controller
@RequestMapping({ "/bookLend" })
public class bookLendController {
    private static final Logger logger = Logger.getLogger(bookLendController.class);
    @Autowired
    private bookLendService booklendservice;
    @RequestMapping(method = { RequestMethod.GET },value = "ByYear")
    @ResponseBody
    //1.返回历年图书馆借阅书总数
    public Map<String ,List> getBorrowCountByYear(HttpServletRequest request) {
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByYear(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByMonth")
    @ResponseBody

    //2.返回历年每月图书馆借阅书总数
    public Map<String ,List> getBorrowCountByMonth(HttpServletRequest request) {
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByMonth(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByDay")
    @ResponseBody
    //3.返回历年每月每日图书馆借阅书总数
    public Map<String ,List> getBorrowCountByDay(HttpServletRequest request) {
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByDay(b);
    }


    @RequestMapping(method = { RequestMethod.GET },value = "ByHourAndAcademy")
    @ResponseBody
    //6.返回昨日各时间段各学院图书借还总次数
    public    Map<Integer, HashMap<String ,List>>  getBorrowCountByHourAndAcademy(HttpServletRequest request){
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByHourAndAcademy(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByHourAndBookkinds")
    @ResponseBody
    //7.返回今年段各学院各类图书借阅总次数
    public   Map<String ,List>  getBorrowCountByHourAndBookkinds(HttpServletRequest request){
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByHourAndBookkinds(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "BySexAndBookkinds")
    @ResponseBody
    //9.返回今年每月各性别借阅各图书种类总数
    public Map<String ,List> getBorrowCountBySexAndBookkinds(HttpServletRequest request){
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountBySexAndBookkinds(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByPublisher")
    @ResponseBody
    //14.返回历年各出版社借阅总数总数
    public  Map<Integer ,Map>  getBorrowCountByPublisher(HttpServletRequest request){
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByPublisher(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByBookkind")
    @ResponseBody
    //10.返回今年各图书种类借阅总数
    public  Map<String,List>  getBookkindCount(HttpServletRequest request){
        Book_Lend b=new Book_Lend();
        return booklendservice.getBookkindCount(b);
    }

}
