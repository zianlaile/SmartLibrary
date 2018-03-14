package com.smartlibrary.dao;

import java.util.*;

import com.smartlibrary.domain.CrossAnalysis;

import java.util.List;

public interface CrossAnalysisDao {
    //按月份统计总比例
    List<CrossAnalysis> CrossAnalysisByDay(CrossAnalysis n);
    List<CrossAnalysis> getCrossAnalysisByMonth(CrossAnalysis n);
     List<CrossAnalysis>getCrossAnalysisByAcademyInUnderGraduate(CrossAnalysis n);
}
