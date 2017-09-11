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
    public Map<String ,List> getGctrlCountByYear(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByYear(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByMonth")
    @ResponseBody
    public Map<String ,List> getGctrlCountByMonth(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByMonth(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByDay")
    @ResponseBody
    public Map<String ,List> getGctrlCountByDay(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByDay(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "ByDay2")
    @ResponseBody
    public Map<String ,List> getGctrlCountByDay2(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByDay2(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByIdentity")
    @ResponseBody
    public Map<String ,List> getGctrlCountByIdentity(HttpServletRequest request) {
        gctrl b=new gctrl();
        return gctrlservice.getGctrlCountByIdentity(b);
    }

    @RequestMapping(method = { RequestMethod.GET },value = "BySexAndAcademy")
    @ResponseBody
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
    public  Map<String,List>  getBookkindCount(HttpServletRequest request){
        gctrl b=new gctrl();
        return gctrlservice.getBookkindCount(b);
    }

}
