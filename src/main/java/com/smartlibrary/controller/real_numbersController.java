package com.smartlibrary.controller;

import com.smartlibrary.domain.real_numbers;
import com.smartlibrary.service.real_numbersService;
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
@RequestMapping({ "/real_numbers" })
public class real_numbersController {
    @Autowired
    private real_numbersService real_numbersservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        real_numbers r = new real_numbers();
        List<real_numbers> datalist  = real_numbersservice.ShowList(r);
        map.put("rows",datalist);
        return map;
    }
}
