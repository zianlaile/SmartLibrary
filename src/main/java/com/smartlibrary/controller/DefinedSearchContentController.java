package com.smartlibrary.controller;

import com.smartlibrary.domain.DefinedBookSearch;
import com.smartlibrary.service.DefinedSearchContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({ "/definedSearchContent" })
public class DefinedSearchContentController {
    private static final Logger logger = Logger.getLogger(DefinedSearchContentController.class);
    @Autowired
    private DefinedSearchContentService definedSearchContentService;

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedContent")
    @ResponseBody
    public Map<String ,List> getDefinedContent(@Valid DefinedBookSearch definedBookSearch, Errors errors) {
        return definedSearchContentService.getDefinedSearchContent();
    }
}
