package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_notice;
import com.smartlibrary.service.bigScreenNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tt on 2017/10/18.
 */
@Controller
@RequestMapping({ "/bigscreennotice" })
public class bigScreenNoticeController {
    @Autowired
    private bigScreenNoticeService bigscreennoticeservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_notice r = new app_notice();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_notice> datalist  = bigscreennoticeservice.ShowList(r);
        int count=bigscreennoticeservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdate(HttpServletRequest request, @RequestBody app_notice adddate) {
        if(0==adddate.getId())
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            adddate.setTime(df.format(new Date()));
            bigscreennoticeservice.add(adddate);}
        else{
            bigscreennoticeservice.update(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        bigscreennoticeservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_notice getbyid(HttpServletRequest request, @RequestBody int id) {
        app_notice result=bigscreennoticeservice.getbyid(id);
        return result;
    }
//获取最新一条可用
    @RequestMapping(value = "/getnew", method = RequestMethod.POST)
    public @ResponseBody
    app_notice getnew(HttpServletRequest request, @RequestBody int id) {
        app_notice result=bigscreennoticeservice.getnew();
        return result;
    }
}
