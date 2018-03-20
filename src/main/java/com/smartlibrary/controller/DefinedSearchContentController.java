package com.smartlibrary.controller;

import com.smartlibrary.service.DefinedSearchContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({ "/definedSearchContent" })
public class DefinedSearchContentController {
    private static final Logger logger = Logger.getLogger(DefinedSearchContentController.class);
    @Autowired
    private DefinedSearchContentService definedSearchContentService;

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedBookContent")
    @ResponseBody
    public Map<String ,List> getDefinedBookContent() {
        return definedSearchContentService.getDefinedBookSearchContent();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedGctrlContent")
    @ResponseBody
    public Map<String ,List> getDefinedGctrlContent() {
        return definedSearchContentService.getDefinedGctrlSearchContent();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedIcContent")
    @ResponseBody
    public Map<String ,List> getDefinedIcContent() {
        return definedSearchContentService.getDefinedIcSearchContent();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedPrintContent")
    @ResponseBody
    public Map<String ,List> getDefinedPrintContent() {
        return definedSearchContentService.getDefinedPrintSearchContent();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedPersonAssetContent")
    @ResponseBody
    public Map<String ,List> getDefinedPersonAssetContent() {
        return definedSearchContentService.getDefinedPersonAssetSearchContent();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "getDefinedRankContent")
    @ResponseBody
    public Map<String ,List> getDefinedRankContent() {
        return definedSearchContentService.getDefinedRankContent();
    }


}
