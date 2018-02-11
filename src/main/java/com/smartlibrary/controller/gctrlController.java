package com.smartlibrary.controller;

import com.smartlibrary.domain.gctrl;
import com.smartlibrary.service.gctrlService;
import org.apache.log4j.Logger;
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
 * Created by tt on 2017/7/18.
 */
@Controller
@RequestMapping({ "/gctrl" })
public class gctrlController {
    private static final Logger logger = Logger.getLogger(gctrlController.class);
    @Autowired
    gctrlService gctrlservice;
    @RequestMapping(method = { RequestMethod.GET },value = "ByYear")
    @ResponseBody
    //15.返回历年图书馆进馆总数
    public Map<String ,List> getGctrlCountByYear(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByYear(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByMonth")
    @ResponseBody
    //16.返回历年每月图书馆进馆总数
    public Map<String ,List> getGctrlCountByMonth(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByMonth(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByDay")
    @ResponseBody
    //17.返回历年每月每日图书馆进馆总数
    public Map<String ,List> getGctrlCountByDay(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByDay(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByDay2")
    @ResponseBody
    //19.返回当年每日进馆人数统计总数
    public Map<String ,List> getGctrlCountByDay2(HttpServletRequest request) {
        gctrl b=new gctrl();
        Calendar now = Calendar.getInstance();
        if(request.getQueryString()==null){
            b.setYear(now.get(Calendar.YEAR));
        }
        else{
            b.setYear(Integer.valueOf(request.getQueryString()));
        }
        return gctrlservice.getGctrlCountByDay2(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByIdentity")
    @ResponseBody
    //21.返回历年各身份人员进馆总数
    public Map<String ,List> getGctrlCountByIdentity(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByIdentity(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "BySexAndAcademy")
    @ResponseBody
    //22.返回当月每天各性别人员进馆总数
    public Map<String ,List> getGctrlCountBySexAndAcademy(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountBySexAndAcademy(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByAcademyAndMajor")
    @ResponseBody
    public  List<gctrl> getGctrlCountByAcademyAndMajor(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByAcademyAndMajor(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByDay_count2")
    @ResponseBody
    //20.返回当年每日进馆人数总数top12
    public  Map<String,List>  getBookkindCount(HttpServletRequest request){
        gctrl b=new gctrl();
        Calendar now = Calendar.getInstance();
        if(request.getQueryString()==null){
            b.setYear(now.get(Calendar.YEAR));
        }
        else{
            b.setYear(Integer.valueOf(request.getQueryString()));
        }
        return gctrlservice.getBookkindCount(b);
    }

}
