package com.smartlibrary.controller;

import com.smartlibrary.domain.DefinedBookSearch;
import com.smartlibrary.service.DefinedSearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping({ "/definedSearch" })
public class DefinedSearchController {
    private static final Logger logger = Logger.getLogger(DefinedSearchController.class);
    @Autowired
    private DefinedSearchService definedSearchService;

    @RequestMapping(value = "getDefinedBookSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedBookSearch(@Valid DefinedBookSearch definedBookSearch,Errors errors) {
        System.out.println(definedBookSearch.toString());
        return definedSearchService.getDefinedBookSearch(definedBookSearch,errors);
    }
}
