package com.smartlibrary.controller;

import com.smartlibrary.service.bigScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/9/11.
 */
@Controller
@RequestMapping({ "/bigscreen" })
public class bigscreenController {
    @Autowired
    private bigScreenService bigscreenservice;
    @RequestMapping(method = { RequestMethod.GET },value = "/number")
    @ResponseBody
    public Map<String,String> GetNumber(){
       return bigscreenservice.getNumber();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/icpremonth")
    @ResponseBody
    public Map<String,String> GetIcpremonth(){
        return bigscreenservice.getIcpremonth();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/printpremonth")
    @ResponseBody
    public Map<String,String> GetPrintpremonth(){
        return bigscreenservice.getPrintpremonth();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/rating")
    @ResponseBody
    public Map<String,String> GetRating(){
        return bigscreenservice.getRating();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/lend")
    @ResponseBody
    public Map<String,List> GetLend(){
        return bigscreenservice.getLend();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/resource")
    @ResponseBody
    public Map<String,List> GetResource(){
        return bigscreenservice.getResource();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/gctrl")
    @ResponseBody
    public Map<String,List> GetGctrl(){
        return bigscreenservice.getGctrl();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/lend_academy")
    @ResponseBody
    public Map<String,List> Getlend_academy(){
        return bigscreenservice.getLend_academy();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/gctrl_academy")
    @ResponseBody
    public Map<String,List> Getgctrl_academy(){
        return bigscreenservice.getGctrl_academy();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/lend_academy_new")
    @ResponseBody
    public Map<String,List> Getlend_academy_new(){
        return bigscreenservice.getLend_academy_new();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/gctrl_academy_new")
    @ResponseBody
    public Map<String,List> Getgctrl_academy_new(){
        return bigscreenservice.getGctrl_academy_new();
    }
    @RequestMapping(method = { RequestMethod.GET },value = "/sysfxx")
    @ResponseBody
    public Map<String,String> Getsysfxx(){
        return bigscreenservice.getSysfxx();
    }
}
