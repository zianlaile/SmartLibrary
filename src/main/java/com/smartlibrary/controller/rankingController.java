package com.smartlibrary.controller;

import com.smartlibrary.domain.ranking;
import com.smartlibrary.service.rankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/12/4.
 */
@Controller
@RequestMapping({ "/ranking" })
public class rankingController {
    @Autowired
    private rankingService rankingservice;
    private Calendar cal = Calendar.getInstance();
    @RequestMapping(method = { RequestMethod.GET },value = "lend_book_year")
    @ResponseBody
    //24.返回历年借阅的图书排行top10
    public  Map<Integer ,Map>  getranking_lend_book_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_book_year(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "lend_reader_year")
    @ResponseBody
    //25.返回历年个人借阅图书数量的排行top10
    public  Map<Integer ,Map>  getranking_lend_reader_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_reader_year(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "lend_academy_book_year")
    @ResponseBody
    //26.返回今年个学院借阅图书数量的排行top10
    public  Map<String ,Map>  getranking_lend_academy_book_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_academy_book_year(b);
    }


    @RequestMapping(method = { RequestMethod.GET },value = "lend_academy_reader_year")
    @ResponseBody
    //27.返回今年个学院个人借阅图书数量的排行top10
    public  Map<String ,Map>  getranking_lend_academy_reader_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_academy_reader_year(b);
    }



    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_month")
    @ResponseBody
    //28返回今年月进馆量排行top10
    public   Map<String,List>  getranking_gctrl_month(HttpServletRequest request){
        ranking b=new ranking();
        b.setYear(cal.get(Calendar.YEAR));
        return rankingservice.getranking_gctrl_month(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_day")
    @ResponseBody
    //29 返回今年每日进馆量排行top10
    public   Map<String,List>  getranking_gctrl_day(HttpServletRequest request){
        ranking b=new ranking();
        b.setYear(cal.get(Calendar.YEAR));
        return rankingservice.getranking_gctrl_day(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_academy_month")
    @ResponseBody
    //30. 返回今年各学院每月进馆量排行top10
    public  Map<String ,Map>  getranking_gctrl_academy_month(HttpServletRequest request){
        ranking b=new ranking();
        b.setYear(cal.get(Calendar.YEAR));
        return rankingservice.getranking_gctrl_academy_month(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_academy_day")
    @ResponseBody
    //31 返回今年各学院每日进馆量排行top10
    public  Map<String ,Map>  geranking_gctrl_academy_day(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.geranking_gctrl_academy_day(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ranking_print_year")
    @ResponseBody
    //31. 返回今年每日打印量排行top10
    public  Map<String,List>   getranking_print_year(HttpServletRequest request){
        ranking b=new ranking();
        b.setYear(cal.get(Calendar.YEAR));
        return rankingservice.getranking_print_year(b);
    }
}
