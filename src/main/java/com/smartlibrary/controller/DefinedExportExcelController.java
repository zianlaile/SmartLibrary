package com.smartlibrary.controller;

import com.smartlibrary.domain.DefinedBookSearch;
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

    @RequestMapping(value = "exportRecords")
    @ResponseBody
    public String exportRecords(@Valid DefinedBookSearch definedBookSearch, Errors errors, HttpServletResponse response){
        System.out.println(definedBookSearch.toString());
        definedExportExcelService.getDefinedBookSearch(definedBookSearch,errors,response);
        return null;
    }
}
