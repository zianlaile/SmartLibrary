package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_book_suggest;
import com.smartlibrary.service.book_suggestService;
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
 * Created by tt on 2017/9/22.
 */
@Controller
@RequestMapping({ "/booksuggest" })
public class BooksuggestController {
    @Autowired
    private book_suggestService book_suggestservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_book_suggest bs = new app_book_suggest();
        bs.setOffset(offset);
        bs.setPageSize(pageSize);
        List<app_book_suggest> datalist  = book_suggestservice.ShowList(bs);
        int count=book_suggestservice.Count(bs);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdatebs", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdatebs(HttpServletRequest request, @RequestBody app_book_suggest adddate) {
        if(0==adddate.getId())
        {book_suggestservice.addbs(adddate);}
        else{book_suggestservice.updatebs(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {

        book_suggestservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbsbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_book_suggest getbsbyid(HttpServletRequest request, @RequestBody int id) {
        app_book_suggest result=book_suggestservice.getbsbyid(id);
        return result;
    }
}
