package com.smartlibrary.controller;

import com.smartlibrary.domain2.Counts;
import com.smartlibrary.service.PersonAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zian on 2017/9/28.
 */
@Controller
@RequestMapping("/personasset")
public class personAssetController {
    @Autowired PersonAssetService personAssetService;

    @RequestMapping(method = {RequestMethod.GET},value = "BySexCount")
    @ResponseBody
    public Map<String,Integer> BySexCount(HttpServletRequest request){
        Map<String,Integer> pdate = new HashMap<>();
        List<Counts> counts = personAssetService.getCountsBySex();

        pdate.put("man",counts.get(0).getCounts());
        pdate.put("female",counts.get(1).getCounts());

        return pdate;
    }

    @RequestMapping(method = {RequestMethod.GET},value = "ByYearCount")
    @ResponseBody
    public Map<String,List> ByYearCount(HttpServletRequest request){
        Map<String,List> ppdate = new HashMap<>();

        List<Counts> counts = personAssetService.getCountsByYear();

        List<String> pyear = new ArrayList<>();
        List<Integer> pcount = new ArrayList<>();
        for (Counts c : counts){
            pyear.add(String.valueOf(c.getIname()));
            pcount.add(c.getCounts());

        }
        ppdate.put("pyear",pyear);
        ppdate.put("pcount",pcount);
        return ppdate;
    }


    @RequestMapping(method = {RequestMethod.GET},value = "ByPurchaseDateCount")
    @ResponseBody
    public Map<String,List> ByPurchaseDateCount(HttpServletRequest request){

        Map<String,List> data = new HashMap<>();

        List<Counts> counts = personAssetService.getAssetCountsByYear();

        List<String> ayear = new ArrayList<>();
        List<Integer> acount = new ArrayList<>();
        for (Counts c : counts){
            ayear.add(String.valueOf(c.getIname()));
            acount.add(c.getCounts());

        }
        data.put("ayear",ayear);
        data.put("acount",acount);
        return data;
    }


    @RequestMapping(method = {RequestMethod.GET},value = "ByFloorCount")
    @ResponseBody
    public Map<String,List> ByFloorCount(HttpServletRequest request){

        Map<String,List> data = new HashMap<>();

        List<Counts> counts = personAssetService.getAssetCountsByFloor();


        List<String> afloor = new ArrayList<>();
        List<Integer> acount = new ArrayList<>();


        for (Counts c : counts){
            afloor.add(c.getSname());
            acount.add(c.getCounts());

        }
        data.put("afloor",afloor);
        data.put("acount",acount);




        return data;
    }

}
