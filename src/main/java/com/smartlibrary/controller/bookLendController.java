package com.smartlibrary.controller;

import com.smartlibrary.domain.Book_Lend;
import com.smartlibrary.service.bookLendService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/7/17.
 */
@Controller
@RequestMapping({ "/bookLend" })
public class bookLendController {
    private static final Logger logger = Logger.getLogger(bookLendController.class);
    @Autowired
    private bookLendService booklendservice;
    @RequestMapping(method = { RequestMethod.GET },value = "ByYear")
    @ResponseBody
    public Map<String ,List> getBorrowCountByYear(HttpServletRequest request) {
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByYear(b);
    }
    @RequestMapping(method = { RequestMethod.GET },value = "ByMonth")
    @ResponseBody
    public Map<String ,List> getBorrowCountByMonth(HttpServletRequest request) {
        Book_Lend b=new Book_Lend();
        return booklendservice.getBorrowCountByMonth(b);
    }

}
