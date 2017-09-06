package com.smartlibrary.service;

import com.smartlibrary.dao.gctrlDao;
import com.smartlibrary.domain.gctrl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by tt on 2017/7/18.
 */
@Service
public class gctrlService {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private gctrlDao gctrldao;
    public Map<String,List> getGctrlCountByYear(gctrl b) {
        List<gctrl> year= gctrldao.getGctrlCountByYear(b);
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<year.size();i++){
            gctrl_times.add(year.get(i).getGctrl_times());
            times.add(String.valueOf(year.get(i).getYear()));
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        return data;
    }

    public Map<String,List> getGctrlCountByMonth(gctrl b) {
        List<gctrl> month= gctrldao.getGctrlCountByMonth(b);
        gctrl bl;
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<month.size();i++){
            bl=month.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"/"+String.valueOf(bl.getMonth()));
            //组成返回对象X轴与Y轴
            gctrl_times.add(month.get(i).getGctrl_times());
            times.add(month.get(i).getTime());
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        return data;
    }

    public Map<String,List> getGctrlCountByDay(gctrl b) {

        List<gctrl> day= gctrldao.getGctrlCountByDay(b);
        gctrl bl;
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<day.size();i++){
            bl=day.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"/"+String.valueOf(bl.getMonth())+"/"+String.valueOf(bl.getDay()));
            //组成返回对象X轴与Y轴
            gctrl_times.add(day.get(i).getGctrl_times());
            times.add(day.get(i).getTime());
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        return data;
    }

    public Map<String,List> getGctrlCountByDay2(gctrl b) {
        List<gctrl> day2= gctrldao.getGctrlCountByDay2(b);
        gctrl bl;
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        ArrayList<Integer> year=new  ArrayList<Integer>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<day2.size();i++){
            year.add(day2.get(0).getYear());
            bl=day2.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"-"+String.valueOf(bl.getMonth())+"-"+String.valueOf(bl.getDay()));
            //组成返回对象X轴与Y轴
            gctrl_times.add(day2.get(i).getGctrl_times());
            times.add(day2.get(i).getTime());
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        data.put("year",year);
        return data;
    }

    public    Map<String,List> getGctrlCountByIdentity(gctrl b){
        Map<String,List> result=new TreeMap<String,List>();
        List<gctrl> Identity= gctrldao.getGctrlCountByIdentity(b);
        Set academy=new TreeSet();//取不同的学院
        Set year=new TreeSet();//取不同的年份
        for(int i=0;i<Identity.size();i++){
            academy.add(Identity.get(i).getAcademy());
            year.add(Identity.get(i).getYear());
        }
        Iterator<String> academyit = academy.iterator();
        ArrayList<String> academylist=new  ArrayList<String>();
        while(academyit.hasNext()) {
            String  Sacademy = academyit.next();
            academylist.add(Sacademy);
        }

        Iterator<Integer> yearit = year.iterator();
        ArrayList<Integer> yearlist=new  ArrayList<Integer>();
        while(yearit.hasNext()) {
            int oneyear =yearit.next();
            yearlist.add(oneyear);
        }
        ArrayList<Map> data=new ArrayList<Map>();
        TreeMap<Integer ,List> Undergraduate_times=new TreeMap<Integer ,List>();
        TreeMap<Integer ,List> Graduate_times=new TreeMap<Integer ,List>();
        TreeMap<Integer ,List> Teacher_times=new TreeMap<Integer ,List>();
        TreeMap<Integer ,List> Other_times=new TreeMap<Integer ,List>();
        for (int i=0;i<yearlist.size();i++) {
            int iyear=yearlist.get(i);
            ArrayList<Integer> Undergraduate_time_data=new ArrayList<Integer>();
            ArrayList<Integer> Graduate_time_data=new ArrayList<Integer>();
            ArrayList<Integer> Teacher_time_data=new ArrayList<Integer>();
            ArrayList<Integer> Other_time_data=new ArrayList<Integer>();
            for (int k = 0; k < Identity.size(); k++) {
                if(iyear==Identity.get(k).getYear()) {
                    Undergraduate_time_data.add(Identity.get(k).getUndergraduate_times());
                    Graduate_time_data.add(Identity.get(k).getGraduate_times());
                    Teacher_time_data.add(Identity.get(k).getTeacher_times());
                    Other_time_data.add(Identity.get(k).getOther_times());

                }
            }
            Undergraduate_times.put(iyear,Undergraduate_time_data);
            Graduate_times.put(iyear,Graduate_time_data);
            Teacher_times.put(iyear,Teacher_time_data);
            Other_times.put(iyear,Other_time_data);
        }
        data.add(Undergraduate_times);
        data.add(Graduate_times);
        data.add(Teacher_times);
        data.add(Other_times);
        result.put("data",data);
        result.put("academy",academylist);
        result.put("year",yearlist);
        return result;
    }

    public Map<String ,List> getGctrlCountBySexAndAcademy(gctrl b) {
        List<gctrl> sexAndacademy= gctrldao.getGctrlCountBySexAndAcademy(b);
        Map<String ,List> data=new HashMap<String ,List>();
        ArrayList<Map> manAndwoman=new  ArrayList<Map>();


        Set oneday=new TreeSet();
        Set academy=new TreeSet();

        Map<Integer ,List> man=new HashMap<Integer ,List>();
        Map<Integer ,List> woman=new HashMap<Integer ,List>();

        for(int i=0;i<sexAndacademy.size();i++){
            oneday.add(sexAndacademy.get(i).getDay());
            academy.add(sexAndacademy.get(i).getAcademy());
        }

        Iterator<Integer> onedayit = oneday.iterator();
        ArrayList<Integer> onedaylist=new  ArrayList<Integer>();

        Iterator<String> academyit = academy.iterator();
        ArrayList<String> academylist=new  ArrayList<String>();

        while(onedayit.hasNext()) {
            int  day =onedayit.next();
            onedaylist.add(day);
        }

        while(academyit.hasNext()) {
            String  Sacademy =academyit.next();
            academylist.add(Sacademy);
        }

        for (int j = 0; j < onedaylist.size(); j++) {
            int day =onedaylist.get(j);
            ArrayList<Integer> mandata=new  ArrayList<Integer>();
            ArrayList<Integer> womandata=new  ArrayList<Integer>();
            for (int k = 0; k < sexAndacademy.size(); k++) {
                if(day==sexAndacademy.get(k).getDay()){
                    mandata.add(sexAndacademy.get(k).getM_times());
                    womandata.add(sexAndacademy.get(k).getF_times());
                }
            }
            man.put(day,mandata);
            woman.put(day,womandata);
        }
        manAndwoman.add(man);
        manAndwoman.add(woman);
        data.put("manAndwoman",manAndwoman);
        data.put("academylist",academylist);
        data.put("onedaylist",onedaylist);
        return data;
    }

    public  List<gctrl> getGctrlCountByAcademyAndMajor(gctrl b){
        return gctrldao.getGctrlCountByAcademyAndMajor(b);
    }
}
