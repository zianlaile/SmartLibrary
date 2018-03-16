package com.smartlibrary.service;
import com.smartlibrary.dao.CrossAnalysisDao;
import com.smartlibrary.domain.CrossAnalysis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;

@Service
public class CrossAnalysisService {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private CrossAnalysisDao crossAnalysisdao;


    public List<CrossAnalysis> CrossAnalysisByDay(CrossAnalysis n) {
        return crossAnalysisdao.CrossAnalysisByDay(n); }
    

    public List<CrossAnalysis> getCrossAnalysisByMonth(CrossAnalysis n) {
        return crossAnalysisdao.getCrossAnalysisByMonth(n); }


    public Map<String,List> getCrossAnalysisUtilizationRatio(CrossAnalysis n) {
        List<CrossAnalysis> data = crossAnalysisdao.getCrossAnalysisUtilizationRatio(n);
        Map<String,List> result =  new LinkedHashMap<>();
        List<String>  ic_type = new ArrayList<>();
        List<Integer> day_use_account = new ArrayList<>();
        List<Integer> month_use_account = new ArrayList<>();
        List<Integer> year_use_account = new ArrayList<>();
        for (int i = 0; i < data.size(); i ++){
            ic_type.add(data.get(i).getIc_type());
            day_use_account.add(data.get(i).getDay_use_account());
            month_use_account.add(data.get(i).getMonth_use_account());
            year_use_account.add(data.get(i).getYear_use_account());
        }
        result.put("ic_type",ic_type);
        result.put("day_use_account",day_use_account);
        result.put("month_use_account",month_use_account);
        result.put("year_use_account",year_use_account);
        return  result;
    }

    public  Map<String,ArrayList<CrossAnalysis>>getCrossAnalysisByAcademyInUnderGraduate(CrossAnalysis n){
        List<CrossAnalysis> data = crossAnalysisdao.getCrossAnalysisByAcademyInUnderGraduate(n);
        Map<String,ArrayList<CrossAnalysis> > result =  new TreeMap<String,ArrayList<CrossAnalysis> >();
        for(int i=0;i<data.size();i++){
            CrossAnalysis a = data.get(i);
            String temp = a.getAcademy();
            if(!result.containsKey(temp)){
                ArrayList<CrossAnalysis> datalist = new ArrayList<CrossAnalysis>();
                datalist.add(a);
                result.put(temp,datalist);
            }else{
                result.get(temp).add(a);
            }
        }
        return result;
    }
    public  Map<String,ArrayList<CrossAnalysis>>getCrossAnalysisByAcademyInGraduate(CrossAnalysis n){
        List<CrossAnalysis> data = crossAnalysisdao.getCrossAnalysisByAcademyInGraduate(n);
        Map<String,ArrayList<CrossAnalysis> > result =  new TreeMap<String,ArrayList<CrossAnalysis> >();
        for(int i=0;i<data.size();i++){
            CrossAnalysis b = data.get(i);
            String temp1 = b.getAcademy();
            if(!result.containsKey(temp1)){
                ArrayList<CrossAnalysis> datalist = new ArrayList<CrossAnalysis>();
                datalist.add(b);
                result.put(temp1,datalist);
            }else{
                result.get(temp1).add(b);
            }
        }
        return result;
    }
}

