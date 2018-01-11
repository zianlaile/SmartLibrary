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
    public Map<String,List> getPrint_Amount_Byyear(){
        Map yeardata =new HashMap<String,List>();
        List year = new ArrayList<String>();
        List printtimes = new ArrayList<String>();
        List<Print_Times> printtimesdata= printtimesdao.getPrintAmountByyear();
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
    public Map<String,List> getPrint_Times_Bypapertype(){
        Map papertype = new HashMap<String,List>();
        List<Print_Times> papertypedata = printtimesdao.getPrintTimesBypapertype();
        List<String> year = new ArrayList<String>();
        List<Integer> paperdcount = new ArrayList<Integer>();
        List<Integer> paperdtimes = new ArrayList<Integer>();
        List<Integer> paperecount = new ArrayList<Integer>();
        List<Integer> paperetimes = new ArrayList<Integer>();
        List<Integer> paperocount = new ArrayList<Integer>();
        List<Integer> paperotimes = new ArrayList<Integer>();
        for(int i=0;i<papertypedata.size();i++){
            if(!year.contains(String.valueOf(papertypedata.get(i).getYear())+"年")){
                year.add(String.valueOf(papertypedata.get(i).getYear())+"年");
            }
            if(papertypedata.get(i).getPaper_type().equals("e")){
                paperecount.add(papertypedata.get(i).getCounts());
                paperetimes.add(papertypedata.get(i).getPrint_times());
            }
            else if(papertypedata.get(i).getPaper_type().equals("o")){
                paperocount.add(papertypedata.get(i).getCounts());
                paperotimes.add(papertypedata.get(i).getPrint_times());
            }
            if(papertypedata.get(i).getPaper_type().equals("d")){
                paperdcount.add(papertypedata.get(i).getCounts());
                paperdtimes.add(papertypedata.get(i).getPrint_times());
            }
        }
        papertype.put("year",year);
        papertype.put("paperdcount",paperdcount);
        papertype.put("paperecount",paperecount);
        papertype.put("paperocount",paperocount);
        papertype.put("paperdtimes",paperdtimes);
        papertype.put("paperetimes",paperetimes);
        papertype.put("paperotimes",paperotimes);
        return papertype;
    }
    public Map<String,List> getPrint_Times_Bylocation(){
        Map locationdata = new HashMap<String,List>();
        List<String> month = new ArrayList<String>();
        List<Integer> count = new ArrayList<Integer>();
        List<String> location = new ArrayList<String>();
        List<Integer> times = new ArrayList<Integer>();
        List<Integer> money = new ArrayList<Integer>();
        List<Print_Times> getdatabylocation = printtimesdao.getPrintTimesBylocation();
        for(int i=0;i<getdatabylocation.size();i++){
            if(!month.contains(String.valueOf(getdatabylocation.get(i).getYear())+"/"+String.valueOf(getdatabylocation.get(i).getMonth()))){
                month.add(String.valueOf(getdatabylocation.get(i).getYear())+"/"+String.valueOf(getdatabylocation.get(i).getMonth()));
            }
            if(!location.contains(getdatabylocation.get(i).getLocation())){
                location.add(getdatabylocation.get(i).getLocation());
            }
            count.add(getdatabylocation.get(i).getCounts());
            times.add(getdatabylocation.get(i).getPrint_times());
            money.add(getdatabylocation.get(i).getMoney());
        }
        locationdata.put("month",month);
        locationdata.put("location",location);
        locationdata.put("count",count);
        locationdata.put("times",times);
        locationdata.put("money",money);
        return locationdata;
    }
    public Map<String,List> getPrint_Times_Byprinttype(){
        Map printtypedata = new HashMap<String,List>();
        List<String> monthlist = new ArrayList<String>();
        List<String> daylist = new ArrayList<String>();
        List<Integer> monthcountlist = new ArrayList<Integer>();
        List<Print_Times> gettypedata = printtimesdao.getPrintTimesByprinttype();
        List<Integer> typectimes = new ArrayList<Integer>();
        List<Integer> typeptimes = new ArrayList<Integer>();
        List<Integer> typestimes = new ArrayList<Integer>();
        List<Integer> typeccounts = new ArrayList<Integer>();
        List<Integer> typepcounts = new ArrayList<Integer>();
        List<Integer> typescounts = new ArrayList<Integer>();
        List<Print_Times> getdaylist = printtimesdao.getPrintTimesByprinttypeday();
        List<Print_Times> getmonthandcount = printtimesdao.getPrintTimesByprinttypemonth();
        for(int i=0;i<getdaylist.size();i++){
            daylist.add(getdaylist.get(i).getYmddate());
        }
        for(int i=0;i<getmonthandcount.size();i++){
            monthlist.add(String.valueOf(getmonthandcount.get(i).getYear())+"-"+String.format("%02d", getmonthandcount.get(i).getMonth()));
            monthcountlist.add(getmonthandcount.get(i).getDaycount());
        }
        for(int i=0;i<gettypedata.size();i++){
            if(gettypedata.get(i).getPrint_type().equals("C")){
                typectimes.add(gettypedata.get(i).getPrint_times());
                typeccounts.add(gettypedata.get(i).getCounts());
            }
            else if(gettypedata.get(i).getPrint_type().equals("P")){
                typeptimes.add(gettypedata.get(i).getPrint_times());
                typepcounts.add(gettypedata.get(i).getCounts());
            }
            else if(gettypedata.get(i).getPrint_type().equals("S")){
                typestimes.add(gettypedata.get(i).getPrint_times());
                typescounts.add(gettypedata.get(i).getCounts());
            }
        }
        printtypedata.put("typectimes",typectimes);
        printtypedata.put("typeptimes",typeptimes);
        printtypedata.put("typestimes",typestimes);
        printtypedata.put("typeccounts",typeccounts);
        printtypedata.put("typepcounts",typepcounts);
        printtypedata.put("typescounts",typescounts);
        printtypedata.put("daylist",daylist);
        printtypedata.put("monthlist",monthlist);
        printtypedata.put("monthcountlist",monthcountlist);
        return printtypedata;
    }
}
