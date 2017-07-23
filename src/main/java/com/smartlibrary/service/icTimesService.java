package com.smartlibrary.service;

import com.smartlibrary.domain.IC_Times;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartlibrary.dao.icTimesDao;

import java.util.*;

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
    public Map<String,List> getIC_Times_ByTypeAndMonth(){
        Map typeandmonthdata = new HashMap<String,List>();
        List<IC_Times> gettypeandmonthdata= ictimesdao.getICTimesBYTypeAndMonth();
        List croomtimesg = new ArrayList<Integer>();
        List croomtimeso = new ArrayList<Integer>();
        List croomtimest = new ArrayList<Integer>();
        List croomtimesu = new ArrayList<Integer>();
        List ereadtimesg = new ArrayList<Integer>();
        List ereadtimeso = new ArrayList<Integer>();
        List ereadtimest = new ArrayList<Integer>();
        List ereadtimesu = new ArrayList<Integer>();
        List seattimesg = new ArrayList<Integer>();
        List seattimeso = new ArrayList<Integer>();
        List seattimest = new ArrayList<Integer>();
        List seattimesu = new ArrayList<Integer>();
        List equipmenttimesg = new ArrayList<Integer>();
        List equipmenttimeso = new ArrayList<Integer>();
        List equipmenttimest = new ArrayList<Integer>();
        List equipmenttimesu = new ArrayList<Integer>();
        List month = new ArrayList<String>();
        for(int i=0;i<gettypeandmonthdata.size();i++){
            if(!month.contains(String.valueOf(gettypeandmonthdata.get(i).getYear())+"/"+String.valueOf(gettypeandmonthdata.get(i).getMonth()))){
                month.add(String.valueOf(gettypeandmonthdata.get(i).getYear())+"/"+String.valueOf(gettypeandmonthdata.get(i).getMonth()));
            }
            if(gettypeandmonthdata.get(i).getUser_type().equals("G")){
                croomtimesg.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimesg.add(gettypeandmonthdata.get(i).getEread_times());
                seattimesg.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimesg.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("O")){
                croomtimeso.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimeso.add(gettypeandmonthdata.get(i).getEread_times());
                seattimeso.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimeso.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("T")){
                croomtimest.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimest.add(gettypeandmonthdata.get(i).getEread_times());
                seattimest.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimest.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("U")){
                croomtimesu.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimesu.add(gettypeandmonthdata.get(i).getEread_times());
                seattimesu.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimesu.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
        }
        /*Iterator<String> monthit = monthlist.iterator();
        while(monthit.hasNext()) {
            String monthits=monthit.next();
            month.add(monthits);
        }*/
        typeandmonthdata.put("croomtimesg",croomtimesg);
        typeandmonthdata.put("croomtimeso",croomtimeso);
        typeandmonthdata.put("croomtimest",croomtimest);
        typeandmonthdata.put("croomtimesu",croomtimesu);
        typeandmonthdata.put("ereadtimesg",ereadtimesg);
        typeandmonthdata.put("ereadtimeso",ereadtimeso);
        typeandmonthdata.put("ereadtimest",ereadtimest);
        typeandmonthdata.put("ereadtimesu",ereadtimesu);
        typeandmonthdata.put("seattimesg",seattimesg);
        typeandmonthdata.put("seattimeso",seattimeso);
        typeandmonthdata.put("seattimest",seattimest);
        typeandmonthdata.put("seattimesu",seattimesu);
        typeandmonthdata.put("equipmenttimesg",equipmenttimesg);
        typeandmonthdata.put("equipmenttimeso",equipmenttimeso);
        typeandmonthdata.put("equipmenttimest",equipmenttimest);
        typeandmonthdata.put("equipmenttimesu",equipmenttimesu);
        typeandmonthdata.put("month",month);
        return typeandmonthdata;
    }
    public Map<String,List> getIC_Times_ByTypeAndDay(){
        Map typeanddaydata = new HashMap<String,List>();
        List<IC_Times> gettypeanddaydata= ictimesdao.getICTimesByTypeAndDay();
        List croomtimesg = new ArrayList<Integer>();
        List croomtimeso = new ArrayList<Integer>();
        List croomtimest = new ArrayList<Integer>();
        List croomtimesu = new ArrayList<Integer>();
        List ereadtimesg = new ArrayList<Integer>();
        List ereadtimeso = new ArrayList<Integer>();
        List ereadtimest = new ArrayList<Integer>();
        List ereadtimesu = new ArrayList<Integer>();
        List seattimesg = new ArrayList<Integer>();
        List seattimeso = new ArrayList<Integer>();
        List seattimest = new ArrayList<Integer>();
        List seattimesu = new ArrayList<Integer>();
        List equipmenttimesg = new ArrayList<Integer>();
        List equipmenttimeso = new ArrayList<Integer>();
        List equipmenttimest = new ArrayList<Integer>();
        List equipmenttimesu = new ArrayList<Integer>();
        List day = new ArrayList<String>();
        for(int i=0;i<gettypeanddaydata.size();i++){
            if (!day.contains(String.valueOf(gettypeanddaydata.get(i).getYear()) + "/" + String.valueOf(gettypeanddaydata.get(i).getMonth()) + "/" + String.valueOf(gettypeanddaydata.get(i).getDay()))) {
                day.add(String.valueOf(gettypeanddaydata.get(i).getYear())+"/"+String.valueOf(gettypeanddaydata.get(i).getMonth())+"/"+String.valueOf(gettypeanddaydata.get(i).getDay()));
            }
            if(gettypeanddaydata.get(i).getUser_type().equals("G")){
                croomtimesg.add(gettypeanddaydata.get(i).getCroom_duration());
                ereadtimesg.add(gettypeanddaydata.get(i).getEread_duration());
                seattimesg.add(gettypeanddaydata.get(i).getSeat_duration());
                equipmenttimesg.add(gettypeanddaydata.get(i).getEquipment_duration());
            }
            else if(gettypeanddaydata.get(i).getUser_type().equals("O")){
                croomtimeso.add(gettypeanddaydata.get(i).getCroom_duration());
                ereadtimeso.add(gettypeanddaydata.get(i).getEread_duration());
                seattimeso.add(gettypeanddaydata.get(i).getSeat_duration());
                equipmenttimeso.add(gettypeanddaydata.get(i).getEquipment_duration());
            }
            else if(gettypeanddaydata.get(i).getUser_type().equals("T")){
                croomtimest.add(gettypeanddaydata.get(i).getCroom_duration());
                ereadtimest.add(gettypeanddaydata.get(i).getEread_duration());
                seattimest.add(gettypeanddaydata.get(i).getSeat_duration());
                equipmenttimest.add(gettypeanddaydata.get(i).getEquipment_duration());
            }
            else if(gettypeanddaydata.get(i).getUser_type().equals("U")){
                croomtimesu.add(gettypeanddaydata.get(i).getCroom_duration());
                ereadtimesu.add(gettypeanddaydata.get(i).getEread_duration());
                seattimesu.add(gettypeanddaydata.get(i).getSeat_duration());
                equipmenttimesu.add(gettypeanddaydata.get(i).getEquipment_duration());
            }
        }
        /*Iterator<String> dayit = daylist.iterator();
        while(dayit.hasNext()) {
            String dayits=dayit.next();
            day.add(dayits);
        }*/
        typeanddaydata.put("croomtimesg",croomtimesg);
        typeanddaydata.put("croomtimeso",croomtimeso);
        typeanddaydata.put("croomtimest",croomtimest);
        typeanddaydata.put("croomtimesu",croomtimesu);
        typeanddaydata.put("ereadtimesg",ereadtimesg);
        typeanddaydata.put("ereadtimeso",ereadtimeso);
        typeanddaydata.put("ereadtimest",ereadtimest);
        typeanddaydata.put("ereadtimesu",ereadtimesu);
        typeanddaydata.put("seattimesg",seattimesg);
        typeanddaydata.put("seattimeso",seattimeso);
        typeanddaydata.put("seattimest",seattimest);
        typeanddaydata.put("seattimesu",seattimesu);
        typeanddaydata.put("equipmenttimesg",equipmenttimesg);
        typeanddaydata.put("equipmenttimeso",equipmenttimeso);
        typeanddaydata.put("equipmenttimest",equipmenttimest);
        typeanddaydata.put("equipmenttimesu",equipmenttimesu);
        typeanddaydata.put("day",day);
        return typeanddaydata;
    }
}
