package com.smartlibrary.service;

import com.smartlibrary.dao.CrossAnalysisDao;
import com.smartlibrary.domain.MonthCrossAnalysis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrossAnalysisService {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private CrossAnalysisDao crossAnalysisdao;

    public List<MonthCrossAnalysis> getCrossAnalysisByMonth(MonthCrossAnalysis n) {
        return crossAnalysisdao.getCrossAnalysisByMonth(n); }

}
