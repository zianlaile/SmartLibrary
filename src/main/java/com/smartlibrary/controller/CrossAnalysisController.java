package com.smartlibrary.controller;

import com.smartlibrary.domain.*;
import com.smartlibrary.service.CrossAnalysisService;
import com.smartlibrary.service.gctrlService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({ "/cross_analysis" })
public class CrossAnalysisController {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private CrossAnalysisService crossAnalysisService;

    @RequestMapping(value = "/CrossAnalysisByDay", method = RequestMethod.GET)
    public List<CrossAnalysis> CrossAnalysisByDay(){
        CrossAnalysis n=new CrossAnalysis();
        return crossAnalysisService.CrossAnalysisByDay(n);
    }

    @RequestMapping(value = "/getCrossAnalysisByMonth", method = RequestMethod.GET)
    public List<CrossAnalysis> getCrossAnalysisByMonth(){
        CrossAnalysis n=new CrossAnalysis();
        return crossAnalysisService.getCrossAnalysisByMonth(n);
    }
    @RequestMapping(value = "/getCrossAnalysisByAcademyInUnderGraduate", method = RequestMethod.GET)
    public Map<String,ArrayList<CrossAnalysis>> getCrossAnalysisByAcademyInUnderGraduate(CrossAnalysis n){
        return crossAnalysisService.getCrossAnalysisByAcademyInUnderGraduate(n);
    }
    @RequestMapping(value = "/getCrossAnalysisByAcademyInGraduate", method = RequestMethod.GET)
    public Map<String,ArrayList<CrossAnalysis>> getCrossAnalysisByAcademyInGraduate(CrossAnalysis n){
        return crossAnalysisService.getCrossAnalysisByAcademyInGraduate(n);
    }
    @RequestMapping(value = "/getCrossAnalysisUtilizationRatio", method = RequestMethod.GET)
    public Map<String,List> getCrossAnalysisUtilizationRatio(CrossAnalysis n){
        return crossAnalysisService.getCrossAnalysisUtilizationRatio(n);
    }
}


