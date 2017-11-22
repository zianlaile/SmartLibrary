package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.service.reportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 胡云飞 on 2017/11/1.
 */
@Controller
@RequestMapping("/report")
public class reportController {
    @Autowired
    private reportService reportService;
    @RequestMapping(method = { RequestMethod.POST },value = "/getreport")
    @ResponseBody
    public String getReport(@RequestBody String picBase64Info){
        //picBase64Info = picBase64Info.replaceAll(" ", "+");
        System.out.println(picBase64Info);
        return reportService.getReport(picBase64Info);
    }
}
