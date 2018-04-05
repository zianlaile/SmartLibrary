package com.smartlibrary.dao;

import java.util.*;

import com.smartlibrary.domain.CrossAnalysis;

import java.util.List;

public interface CrossAnalysisDao {
     List<CrossAnalysis>CrossAnalysisByDay(CrossAnalysis n);                              //
     List<CrossAnalysis>getCrossAnalysisByMonth(CrossAnalysis n);                         //
     List<CrossAnalysis>getCrossAnalysisByAcademyInUnderGraduate(String year);               //
     List<CrossAnalysis>getCrossAnalysisByAcademyInGraduate(String year);                    //
     List<CrossAnalysis>getCrossAnalysisUtilizationRatioByyear(String year);                 // 资源年利用率
}
