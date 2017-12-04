package com.smartlibrary.service;

import com.smartlibrary.dao.rankingDao;
import com.smartlibrary.domain.ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by tt on 2017/12/4.
 */
@Service
public class rankingService {

    @Autowired
    private rankingDao rankingdao;
    public Map<Integer ,Map> getranking_lend_book_year(ranking b){
        List<ranking> lend_book_year= rankingdao.getranking_lend_book_year(b);
        Map<Integer ,Map> returndata=new TreeMap<Integer ,Map>();
        //得到有几个年份
        Set oneyear=new TreeSet();
        for(int i=0;i<lend_book_year.size();i++){
            oneyear.add(lend_book_year.get(i).getYear());
        }
        Iterator<Integer> oneyearit = oneyear.iterator();
        ArrayList<Integer> oneyearlist=new  ArrayList<Integer>();
        while(oneyearit.hasNext()) {
            int  year =oneyearit.next();
            oneyearlist.add(year);
        }

        for (int j = 0; j < oneyearlist.size(); j++) {
            int year =oneyearlist.get(j);
            ArrayList<String> lend_book_oneyear=new  ArrayList<String>();
            ArrayList<Integer> times=new  ArrayList<Integer>();
            Map<String ,List> data=new TreeMap<String ,List>();
            for (int k = 0; k < lend_book_year.size(); k++) {
                if(year==lend_book_year.get(k).getYear()){
                    lend_book_oneyear.add(lend_book_year.get(k).getBook_name());
                    times.add(lend_book_year.get(k).getLend_times());
                }
            }
            data.put("lend_book_oneyear",lend_book_oneyear);
            data.put("times",times);
            returndata.put(year,data);
        }
        return returndata;
    }


    public Map<Integer ,Map> getranking_lend_reader_year(ranking b){
        List<ranking> lend_book_year= rankingdao.getranking_lend_reader_year(b);
        Map<Integer ,Map> returndata=new TreeMap<Integer ,Map>();
        //得到有几个年份
        Set oneyear=new TreeSet();
        for(int i=0;i<lend_book_year.size();i++){
            oneyear.add(lend_book_year.get(i).getYear());
        }
        Iterator<Integer> oneyearit = oneyear.iterator();
        ArrayList<Integer> oneyearlist=new  ArrayList<Integer>();
        while(oneyearit.hasNext()) {
            int  year =oneyearit.next();
            oneyearlist.add(year);
        }

        for (int j = 0; j < oneyearlist.size(); j++) {
            int year =oneyearlist.get(j);
            ArrayList<String> lend_book_oneyear=new  ArrayList<String>();
            ArrayList<Integer> times=new  ArrayList<Integer>();
            Map<String ,List> data=new TreeMap<String ,List>();
            for (int k = 0; k < lend_book_year.size(); k++) {
                if(year==lend_book_year.get(k).getYear()){
                    lend_book_oneyear.add(lend_book_year.get(k).getName());
                    times.add(lend_book_year.get(k).getLend_times());
                }
            }
            data.put("lend_book_oneyear",lend_book_oneyear);
            data.put("times",times);
            returndata.put(year,data);
        }
        return returndata;
    }






    public Map<String ,Map> getranking_lend_academy_reader_year(ranking b){
        List<ranking> lend_book_year= rankingdao.getranking_lend_academy_reader_year(b);
        Map<String ,Map> returndata=new TreeMap<String ,Map>();
        //得到有几个学院
        Set oneacademy=new TreeSet();
        for(int i=0;i<lend_book_year.size();i++){
            oneacademy.add(lend_book_year.get(i).getAcademy());
        }
        Iterator<String> oneacademyit = oneacademy.iterator();
        ArrayList<String> oneacademylist=new  ArrayList<String>();
        while(oneacademyit.hasNext()) {
            String  academy =oneacademyit.next();
            oneacademylist.add(academy);
        }

        for (int j = 0; j < oneacademylist.size(); j++) {
            String  academy =oneacademylist.get(j);
            ArrayList<String> lend_book_oneyear=new  ArrayList<String>();
            ArrayList<Integer> times=new  ArrayList<Integer>();
            Map<String ,List> data=new TreeMap<String ,List>();
            for (int k = 0; k < lend_book_year.size(); k++) {
                if(academy.equals(lend_book_year.get(k).getAcademy())){
                    lend_book_oneyear.add(lend_book_year.get(k).getName());
                    times.add(lend_book_year.get(k).getLend_times());
                }
            }
            data.put("lend_book_oneyear",lend_book_oneyear);
            data.put("times",times);
            returndata.put(academy,data);
        }
        return returndata;
    }


    public Map<String,List> getranking_gctrl_month(ranking b) {
        List<ranking> year= rankingdao.getranking_gctrl_month(b);
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<year.size();i++){
            gctrl_times.add(year.get(i).getGctrl_times());
            times.add(String.valueOf(year.get(i).getMonth()));
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        return data;
    }

    public Map<String,List> getranking_gctrl_day(ranking b) {
        List<ranking> year= rankingdao.getranking_gctrl_day(b);
        ArrayList<Integer> gctrl_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<year.size();i++){
            gctrl_times.add(year.get(i).getGctrl_times());
            times.add(year.get(i).getYmdchar());
        }
        data.put("gctrl_times",gctrl_times);
        data.put("times",times);
        return data;
    }



    public Map<String ,Map> getranking_gctrl_academy_month(ranking b){
        List<ranking> gctrl_academy_year= rankingdao.getranking_gctrl_academy_month(b);
        Map<String ,Map> returndata=new TreeMap<String ,Map>();
        //得到有几个学院
        Set oneacademy=new TreeSet();
        for(int i=0;i<gctrl_academy_year.size();i++){
            oneacademy.add(gctrl_academy_year.get(i).getAcademy());
        }
        Iterator<String> oneacademyit = oneacademy.iterator();
        ArrayList<String> oneacademylist=new  ArrayList<String>();
        while(oneacademyit.hasNext()) {
            String  academy =oneacademyit.next();
            oneacademylist.add(academy);
        }

        for (int j = 0; j < oneacademylist.size(); j++) {
            String  academy =oneacademylist.get(j);
            ArrayList<Integer> gctrl_academy_year_oneyear=new  ArrayList<Integer>();
            ArrayList<Integer> times=new  ArrayList<Integer>();
            Map<String ,List> data=new TreeMap<String ,List>();
            for (int k = 0; k < gctrl_academy_year.size(); k++) {
                if(academy.equals(gctrl_academy_year.get(k).getAcademy())){
                    gctrl_academy_year_oneyear.add(gctrl_academy_year.get(k).getMonth());
                    times.add(gctrl_academy_year.get(k).getGctrl_times());
                }
            }
            data.put("gctrl_academy",gctrl_academy_year_oneyear);
            data.put("times",times);
            returndata.put(academy,data);
        }
        return returndata;
    }
}
