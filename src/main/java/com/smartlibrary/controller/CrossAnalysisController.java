package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.CrossAnalysisService;
import com.smartlibrary.service.gctrlService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping({ "/cross_analysis" })
public class CrossAnalysisController {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private CrossAnalysisService crossAnalysisService;

    @RequestMapping(value = "/getCrossAnalysisByMonth", method = RequestMethod.GET)
    public List<MonthCrossAnalysis> getCrossAnalysisByMonth(){
        MonthCrossAnalysis n=new MonthCrossAnalysis();
        return crossAnalysisService.getCrossAnalysisByMonth(n);
    }

}