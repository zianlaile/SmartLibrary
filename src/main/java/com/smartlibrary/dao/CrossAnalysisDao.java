package com.smartlibrary.dao;


import com.smartlibrary.domain.CrossAnalysis;

import java.util.List;

public interface CrossAnalysisDao {
    //按月份统计总比例
    List<CrossAnalysis> getCrossAnalysisByMonth(CrossAnalysis n);
}
