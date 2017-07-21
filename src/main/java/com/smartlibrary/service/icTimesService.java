package com.smartlibrary.service;

import com.smartlibrary.domain.IC_Times;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartlibrary.dao.icTimesDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/7/20.
 */
@Service
public class icTimesService {
    private static final Logger logger = Logger.getLogger(icTimesService.class);
    @Autowired
    private icTimesDao ictimesdao;
    public Map<String,List> getIC_Times_Byyear(){
        Map yeardata =new HashMap<String,List>();
        List year = new ArrayList<String>();
        List croom_times = new ArrayList<Integer>();
        List seat_times = new ArrayList<Integer>();
        List eread_times = new ArrayList<Integer>();
        List<IC_Times> getictimebyyear = ictimesdao.getICTimesByYear();
        for(int i=0;i<getictimebyyear.size();i++){
            year.add(String.valueOf(getictimebyyear.get(i).getYear()));
            croom_times.add(getictimebyyear.get(i).getCroom_times());
            seat_times.add(getictimebyyear.get(i).getSeat_times());
            eread_times.add(getictimebyyear.get(i).getEread_times());
        }
        yeardata.put("year",year);
        yeardata.put("croom_times",croom_times);
        yeardata.put("seat_times",seat_times);
        yeardata.put("eread_times",eread_times);
        return yeardata;
    }
    public Map<String,List> getIC_Times_ByMonth(){
        Map monthdata =new HashMap<String,List>();
        List month = new ArrayList<String>();
        List croom_times = new ArrayList<Integer>();
        List seat_times = new ArrayList<Integer>();
        List eread_times = new ArrayList<Integer>();
        List<IC_Times> getictimebymonth = ictimesdao.getICTimesByMonth();
        for(int i=0;i<getictimebymonth.size();i++){
            month.add(String.valueOf(getictimebymonth.get(i).getYear())+"/"+String.valueOf(getictimebymonth.get(i).getMonth()));
            croom_times.add(getictimebymonth.get(i).getCroom_times());
            seat_times.add(getictimebymonth.get(i).getSeat_times());
            eread_times.add(getictimebymonth.get(i).getEread_times());
        }
        monthdata.put("month",month);
        monthdata.put("croom_times",croom_times);
        monthdata.put("seat_times",seat_times);
        monthdata.put("eread_times",eread_times);
        return monthdata;
    }
    public Map<String,List> getIC_Times_ByDay(){
        Map daydata =new HashMap<String,List>();
        List day = new ArrayList<String>();
        List croom_times = new ArrayList<Integer>();
        List seat_times = new ArrayList<Integer>();
        List eread_times = new ArrayList<Integer>();
        List<IC_Times> getictimebyday = ictimesdao.getICTimesByDay();
        for(int i=0;i<getictimebyday.size();i++){
            day.add(String.valueOf(getictimebyday.get(i).getYear())+"/"+String.valueOf(getictimebyday.get(i).getMonth())+"/"+String.valueOf(getictimebyday.get(i).getDay()));
            croom_times.add(getictimebyday.get(i).getCroom_times());
            seat_times.add(getictimebyday.get(i).getSeat_times());
            eread_times.add(getictimebyday.get(i).getEread_times());
        }
        daydata.put("day",day);
        daydata.put("croom_times",croom_times);
        daydata.put("seat_times",seat_times);
        daydata.put("eread_times",eread_times);
        return daydata;
    }
}
