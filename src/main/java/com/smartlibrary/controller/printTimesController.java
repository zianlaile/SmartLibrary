package com.smartlibrary.controller;

import com.smartlibrary.domain.Print_Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.smartlibrary.service.printTimesService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Created by 胡云飞 on 2017/7/21.
 */
@Controller
@RequestMapping("/printtimes")
public class printTimesController {
    @Autowired
    private printTimesService printtimesservice;
    @RequestMapping(method={RequestMethod.GET},value = "/byyear")
    @ResponseBody
    public Map<String,List> GetPrinttimesByYear(HttpServletRequest request){
        return printtimesservice.getPrint_Times_Byyear();
    }
    @RequestMapping(method={RequestMethod.GET},value = "/bymonth")
    @ResponseBody
    public Map<String,List> GetPrinttimesByMonth(HttpServletRequest request){
        return printtimesservice.getPrint_Times_Bymonth();
    }
    @RequestMapping(method={RequestMethod.GET},value = "/byday")
    @ResponseBody
    public Map<String,List> GetPrinttimesByDay(HttpServletRequest request){
        return printtimesservice.getPrint_Times_Byday();
    }
    @RequestMapping(method={RequestMethod.GET},value = "/bypagetype")
    @ResponseBody
    public Map<String,List> GetPrinttimesBypapertype(HttpServletRequest request){
        return printtimesservice.getPrint_Times_Bypapertype();
    }
    @RequestMapping(method={RequestMethod.GET},value = "/bylocation")
    @ResponseBody
    public Map<String,List> GetPrinttimesBylocation(HttpServletRequest request){
        return printtimesservice.getPrint_Times_Bylocation();
    }
}
