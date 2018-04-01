package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.DefinedExportExcelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping({ "/definedExportExcel" })
public class DefinedExportExcelController {
    private static final Logger logger = Logger.getLogger(DefinedExportExcelController.class);

    @Autowired
    DefinedExportExcelService definedExportExcelService;

    @RequestMapping(value = "exportBookRecords")
    @ResponseBody
    public String exportBookRecords(@Valid DefinedBookSearch definedBookSearch, Errors errors, HttpServletResponse response){
        logger.info(definedBookSearch.toString());
        definedExportExcelService.getDefinedBookSearch(definedBookSearch,errors,response);
        return null;
    }

    @RequestMapping(value = "exportGctrlRecords")
    @ResponseBody
    public String exportGctrlRecords(@Valid DefinedGctrlSearch definedGctrlSearch, Errors errors, HttpServletResponse response){
        logger.info(definedGctrlSearch.toString());
        definedExportExcelService.getDefinedGctrlSearch(definedGctrlSearch,errors,response);
        return null;
    }

    @RequestMapping(value = "exportIcRecords")
    @ResponseBody
    public String exportIcRecords(@Valid DefinedIcSearch definedIcSearch, Errors errors, HttpServletResponse response){
        logger.info(definedIcSearch.toString());
        definedExportExcelService.getDefinedIcSearch(definedIcSearch,errors,response);
        return null;
    }

    @RequestMapping(value = "exportPrintRecords")
    @ResponseBody
    public String exportPrintRecords(@Valid DefinedPrintSearch definedPrintSearch, Errors errors, HttpServletResponse response){
        logger.info(definedPrintSearch.toString());
        definedExportExcelService.getDefinedPrintSearch(definedPrintSearch,errors,response);
        return null;
    }

    @RequestMapping(value = "exportPersonAssetRecords")
    @ResponseBody
    public String exportPersonAssetRecords(@Valid DefinedPersonAssetSearch definedPersonAssetSearch, Errors errors, HttpServletResponse response){
        logger.info(definedPersonAssetSearch.toString());
        definedExportExcelService.getDefinedPersonAssetSearch(definedPersonAssetSearch,errors,response);
        return null;
    }

    @RequestMapping(value = "exportRankRecords")
    @ResponseBody
    public String exportRankRecords(@Valid DefinedRankSearch definedRankSearch, Errors errors, HttpServletResponse response){
        logger.info(definedRankSearch.toString());
        definedExportExcelService.getDefinedRankSearch(definedRankSearch,errors,response);
        return null;
    }
}
