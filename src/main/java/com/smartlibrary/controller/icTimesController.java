package com.smartlibrary.controller;

import com.smartlibrary.domain.IC_Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.smartlibrary.service.icTimesService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/7/20.
 */
@Controller
@RequestMapping("/ictimes")
public class icTimesController {
    @Autowired
    private icTimesService ictimesservice;
    @RequestMapping(method = { RequestMethod.GET },value = "byyear")
    @ResponseBody
    public Map<String,List> GetictimesByYear(HttpServletRequest request){
        return ictimesservice.getIC_Times_Byyear();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "bymonth")
    @ResponseBody
    public Map<String,List> GetictimesByMonth(HttpServletRequest request){
        return ictimesservice.getIC_Times_ByMonth();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "byday")
    @ResponseBody
    public Map<String,List> GetictimesByDay(HttpServletRequest request){
        return ictimesservice.getIC_Times_ByDay();
    }
}
