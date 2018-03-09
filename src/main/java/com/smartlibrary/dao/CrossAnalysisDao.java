package com.smartlibrary.dao;


import com.smartlibrary.domain.MonthCrossAnalysis;

import java.util.List;

public interface CrossAnalysisDao {
    //按月份统计总比例
    List<MonthCrossAnalysis> getCrossAnalysisByMonth(MonthCrossAnalysis n);
}
