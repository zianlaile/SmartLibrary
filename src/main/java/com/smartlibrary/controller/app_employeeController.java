package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_employee;
import com.smartlibrary.service.app_employeeService;
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
@RequestMapping({ "/employee" })
public class app_employeeController {
    @Autowired
    private app_employeeService app_employeeservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_employee r = new app_employee();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_employee> datalist  = app_employeeservice.ShowList(r);
        int count=app_employeeservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdate(HttpServletRequest request, @RequestBody app_employee adddate) {
        if(0==adddate.getDwAccNo())
        {
            System.out.println("add");
            System.out.println(adddate.getSzPID());
            System.out.println(adddate.getSzTrueName());
            System.out.println(adddate.getDwSex());
            System.out.println(adddate.getDwJobTitle());
            System.out.println(adddate.getDwInlandUduTime());

            app_employeeservice.add(adddate);
        }
        else{
            System.out.println("update");
            app_employeeservice.update(adddate);
        }
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        app_employeeservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_employee getbyid(HttpServletRequest request, @RequestBody int id) {
        app_employee result=app_employeeservice.getbyid(id);
        return result;
    }
}
