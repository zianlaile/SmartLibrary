package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_resources;
import com.smartlibrary.service.app_resourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/9/25.
 */
@Controller
@RequestMapping({ "/resources" })
public class app_resourcesController {
    @Autowired
    private app_resourcesService app_resourcesservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_resources r = new app_resources();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_resources> datalist  = app_resourcesservice.ShowList(r);
        int count=app_resourcesservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdate(HttpServletRequest request, @RequestBody app_resources adddate) {
        if(0==adddate.getId())
        {app_resourcesservice.add(adddate);}
        else{app_resourcesservice.update(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        app_resourcesservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_resources getbyid(HttpServletRequest request, @RequestBody int id) {
        app_resources result=app_resourcesservice.getbyid(id);
        return result;
    }
    
}
