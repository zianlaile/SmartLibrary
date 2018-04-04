package com.smartlibrary.dao;

import java.util.*;

import com.smartlibrary.domain.CrossAnalysis;

import java.util.List;

public interface CrossAnalysisDao {
     List<CrossAnalysis>CrossAnalysisByDay(CrossAnalysis n);
     List<CrossAnalysis>getCrossAnalysisByMonth(CrossAnalysis n);
     List<CrossAnalysis>getCrossAnalysisByAcademyInUnderGraduate(CrossAnalysis n);
     List<CrossAnalysis>getCrossAnalysisByAcademyInGraduate(CrossAnalysis n);
     List<CrossAnalysis>getCrossAnalysisUtilizationRatioByyear(int year); // 资源利用年
}
