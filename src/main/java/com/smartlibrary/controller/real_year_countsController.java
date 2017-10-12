package com.smartlibrary.controller;

import com.smartlibrary.domain.real_year_counts;
import com.smartlibrary.service.real_year_countsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/10/12.
 */
@Controller
@RequestMapping({ "/real_year_counts" })
public class real_year_countsController {
    @Autowired
    private real_year_countsService real_year_countsservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        real_year_counts r = new real_year_counts();
        List<real_year_counts> datalist  = real_year_countsservice.ShowList(r);
        map.put("rows",datalist);
        return map;
    }
}
