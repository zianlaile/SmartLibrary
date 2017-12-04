package com.smartlibrary.controller;

import com.smartlibrary.domain.ranking;
import com.smartlibrary.service.rankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(method = { RequestMethod.GET },value = "lend_book_year")
    @ResponseBody
    public  Map<Integer ,Map>  getranking_lend_book_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_book_year(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "lend_reader_year")
    @ResponseBody
    public  Map<Integer ,Map>  getranking_lend_reader_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_reader_year(b);
    }



    @RequestMapping(method = { RequestMethod.GET },value = "lend_academy_reader_year")
    @ResponseBody
    public  Map<String ,Map>  getranking_lend_academy_reader_year(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_lend_academy_reader_year(b);
    }



    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_month")
    @ResponseBody
    public   Map<String,List>  getranking_gctrl_month(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_gctrl_month(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_day")
    @ResponseBody
    public   Map<String,List>  getranking_gctrl_day(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_gctrl_day(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ranking_gctrl_academy_month")
    @ResponseBody
    public  Map<String ,Map>  getranking_gctrl_academy_month(HttpServletRequest request){
        ranking b=new ranking();
        return rankingservice.getranking_gctrl_academy_month(b);
    }
}
