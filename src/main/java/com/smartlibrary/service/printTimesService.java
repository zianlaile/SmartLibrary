package com.smartlibrary.service;

import com.smartlibrary.domain.Print_Times;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartlibrary.dao.printTimesDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/7/21.
 */
@Service
public class printTimesService {
    private static final Logger logger = Logger.getLogger(icTimesService.class);
    @Autowired
    private printTimesDao printtimesdao;
    public Map<String,List> getPrint_Times_Byyear(){
        Map yeardata =new HashMap<String,List>();
        List year = new ArrayList<String>();
        List printtimes = new ArrayList<String>();
        List<Print_Times> printtimesdata= printtimesdao.getPrintTimesByyear();
        for(int i=0;i<printtimesdata.size();i++){
            year.add(String.valueOf(printtimesdata.get(i).getYear()));
            printtimes.add(printtimesdata.get(i).getPrint_times());
        }
        yeardata.put("year",year);
        yeardata.put("printtimes",printtimes);
        return yeardata;
    }
    public Map<String,List> getPrint_Times_Bymonth(){
        Map monthdata =new HashMap<String,List>();
        List month = new ArrayList<String>();
        List printtimes = new ArrayList<String>();
        List<Print_Times> printtimesdata= printtimesdao.getPrintTimesBymonth();
        for(int i=0;i<printtimesdata.size();i++){
            month.add(String.valueOf(printtimesdata.get(i).getYear())+"/"+String.valueOf(printtimesdata.get(i).getMonth()));
            printtimes.add(printtimesdata.get(i).getPrint_times());
        }
        monthdata.put("month",month);
        monthdata.put("printtimes",printtimes);
        return monthdata;
    }
    public Map<String,List> getPrint_Times_Byday(){
        Map daydata =new HashMap<String,List>();
        List day = new ArrayList<String>();
        List printtimes = new ArrayList<String>();
        List<Print_Times> printtimesdata= printtimesdao.getPrintTimesByday();
        for(int i=0;i<printtimesdata.size();i++){
            day.add(String.valueOf(printtimesdata.get(i).getYear())+"/"+String.valueOf(printtimesdata.get(i).getMonth())+"/"+String.valueOf(printtimesdata.get(i).getDay()));
            printtimes.add(printtimesdata.get(i).getPrint_times());
        }
        daydata.put("day",day);
        daydata.put("printtimes",printtimes);
        return daydata;
    }
}
