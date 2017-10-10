package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain.app_baseinfo;
import com.smartlibrary.service.app_baseinfoService;
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
 * Created by tt on 2017/10/10.
 */
@Controller
@RequestMapping({ "/baseinfo" })
public class app_baseinfoController {
    @Autowired
    private app_baseinfoService app_baseinfoservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_baseinfo r = new app_baseinfo();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_baseinfo> datalist  = app_baseinfoservice.ShowList(r);
        int count=app_baseinfoservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdate(HttpServletRequest request, @RequestBody app_baseinfo adddate) {
        if(0==adddate.getId())
        {app_baseinfoservice.add(adddate);}
        else{app_baseinfoservice.update(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        app_baseinfoservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_baseinfo getbyid(HttpServletRequest request, @RequestBody int id) {
        app_baseinfo result=app_baseinfoservice.getbyid(id);
        return result;
    }

}
