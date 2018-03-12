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

    public List<CrossAnalysis> getCrossAnalysisByMonth(CrossAnalysis n) {
        return crossAnalysisdao.getCrossAnalysisByMonth(n); }

    public  Map<String,ArrayList<CrossAnalysis>>getCrossAnalysisByAcademyInUnderGraduate(CrossAnalysis n){
        List<CrossAnalysis> data = crossAnalysisdao.getCrossAnalysisByAcademyInUnderGraduate(n);
        Map<String,ArrayList<CrossAnalysis> > result =  new TreeMap<String,ArrayList<CrossAnalysis> >();
        for(int i=0;i<data.size();i++){
            CrossAnalysis a = data.get(i);
            String temp = a.getAcademy();
            if(!result.containsKey(temp)){                  // 判断是否是第一个
                ArrayList<CrossAnalysis> datalist = new ArrayList<CrossAnalysis>();
                datalist.add(a);
                result.put(temp,datalist);
            }else{
                result.get(temp).add(a);
            }
        }
        return result;
    }
}
