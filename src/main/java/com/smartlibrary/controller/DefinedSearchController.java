package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.domain2.DefinedPersonAssetSearch;
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
        logger.info(definedBookSearch.toString());
        return definedSearchService.getDefinedBookSearch(definedBookSearch,errors);
    }

    @RequestMapping(value = "getDefinedGctrlSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedGctrlSearch(@Valid DefinedGctrlSearch definedGctrlSearch, Errors errors) {
        logger.info(definedGctrlSearch.toString());
        return definedSearchService.getDefinedGctrlSearch(definedGctrlSearch,errors);
    }

    @RequestMapping(value = "getDefinedIcSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedIcSearch(@Valid DefinedIcSearch definedIcSearch, Errors errors) {
        logger.info(definedIcSearch.toString());
        return definedSearchService.getDefinedIcSearch(definedIcSearch,errors);
    }

    @RequestMapping(value = "getDefinedPrintSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedPrintSearch(@Valid DefinedPrintSearch definedPrintSearch, Errors errors) {
        logger.info(definedPrintSearch.toString());
        return definedSearchService.getDefinedPrintSearch(definedPrintSearch,errors);
    }

    @RequestMapping(value = "getDefinedPersonAssetSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedPersonAssetSearch(@Valid DefinedPersonAssetSearch definedPersonAssetSearch, Errors errors) {
        logger.info(definedPersonAssetSearch.toString());
        return definedSearchService.getDefinedPersonAssetSearch(definedPersonAssetSearch,errors);
    }

    @RequestMapping(value = "getDefinedRankSearch",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String ,List> getDefinedRankSearch(@Valid DefinedRankSearch definedRankSearch, Errors errors) {
        logger.info(definedRankSearch.toString());
        return definedSearchService.getDefinedRankSearch(definedRankSearch,errors);
    }

}
