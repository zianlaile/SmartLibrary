package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_accountManagement;
import com.smartlibrary.service.app_accountManagementService;
import com.smartlibrary.tools.SHAencrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creat by XiaoZhang
 */

@Controller
@RequestMapping({ "/accountManage" })
public class app_accountManagementController {
    @Autowired
    private app_accountManagementService app_accountManagementservice;

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public @ResponseBody
    boolean addAccount(@RequestBody app_accountManagement adddate) {
        try {
            adddate.setPassword(SHAencrypt.encryptSHA(adddate.getPassword()));
        } catch (Exception e) {
        }
        System.out.println("-----------------------------------");
        System.out.println(adddate.getAccount());
        System.out.println(adddate.getPassword());
        System.out.println(adddate.getType());
        System.out.println(adddate.getPermission_allocate());
        System.out.println(adddate.getSchool_id());
        app_accountManagementservice.add(adddate);
        System.out.println("-----------------------------------");
        return true;
    }
    @RequestMapping(value = "/ShowAccountList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize");   //一页多少数据
        int offset = jsonObj.getInteger("offset");      //从第几条数据开始查
        int begin= offset;
        app_accountManagement r = new app_accountManagement();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_accountManagement> datalist  = app_accountManagementservice.showList(r);
        int count=app_accountManagementservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }

}



