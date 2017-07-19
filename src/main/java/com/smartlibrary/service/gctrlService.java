package com.smartlibrary.service;

import com.smartlibrary.dao.gctrlDao;
import com.smartlibrary.domain.gctrl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
