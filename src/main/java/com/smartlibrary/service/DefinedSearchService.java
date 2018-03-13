package com.smartlibrary.service;

import com.smartlibrary.dao.definedSearchDao;
import com.smartlibrary.dao2.definedSearch2Dao;
import com.smartlibrary.domain.*;
import com.smartlibrary.domain2.DefinedPersonAssetSearch;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefinedSearchService {
    private static final Logger logger = Logger.getLogger(DefinedSearchService.class);
    @Autowired
    private definedSearchDao definedsearchDao;

    public Map<String,List> getDefinedBookSearch(DefinedBookSearch definedBookSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList =definedsearchDao.getDefinedBook(definedBookSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        for(int i = 0; i< definedResultList.size(); i++){
            amounts.add(definedResultList.get(i).getAmount());
            times.add(definedResultList.get(i).getTime());
        }
        data.put("amounts",amounts);
        data.put("times",times);
        logger.info("查询成功");
        return data;
    }

    public Map<String,List> getDefinedGctrlSearch(DefinedGctrlSearch definedGctrlSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList=definedsearchDao.getDefinedGctrl(definedGctrlSearch);
        //System.out.println(definedResultList.get(0).toString());

        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        ArrayList<String> academys=new  ArrayList<String>();
        if(definedGctrlSearch.getStyle()==0){
            for(int i=0;i<definedResultList.size();i++){
                amounts.add(definedResultList.get(i).getAmount());
                times.add(definedResultList.get(i).getTime());
            }
            data.put("times",times);
        }else{
            for(int i=0;i<definedResultList.size();i++){
                amounts.add(definedResultList.get(i).getAmount());
                academys.add(definedResultList.get(i).getAcademy());
            }
            data.put("academys",academys);
        }
        data.put("amounts",amounts);
        logger.info("查询成功");
        return data;
    }

    public Map<String,List> getDefinedIcSearch(DefinedIcSearch definedIcSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList=definedsearchDao.getDefinedIc(definedIcSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        for(int i=0;i<definedResultList.size();i++){
            amounts.add(definedResultList.get(i).getAmount());
            times.add(definedResultList.get(i).getTime());
        }
        data.put("times",times);
        data.put("amounts",amounts);
        logger.info("查询成功");
        return data;
    }

    public Map<String,List> getDefinedPrintSearch(DefinedPrintSearch definedPrintSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList =definedsearchDao.getDefinedPrint(definedPrintSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        for(int i = 0; i< definedResultList.size(); i++){
            amounts.add(definedResultList.get(i).getAmount());
            times.add(definedResultList.get(i).getTime());
        }
        data.put("amounts",amounts);
        data.put("times",times);
        logger.info("查询成功");
        return data;
    }

    public Map<String,List> getDefinedPersonAssetSearch(DefinedPersonAssetSearch definedPersonAssetSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList =definedsearchDao.getDefinedPersonAsset(definedPersonAssetSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        for(int i = 0; i< definedResultList.size(); i++){
            amounts.add(definedResultList.get(i).getAmount());
            times.add(String.valueOf(definedResultList.get(i).getYear()));
        }
        data.put("amounts",amounts);
        data.put("times",times);
        logger.info("查询成功");
        return data;
    }

    public Map<String,List> getDefinedRankSearch(DefinedRankSearch definedRankSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            logger.info("查询失败");
            return data;
        }
        List<DefinedResult> definedResultList =definedsearchDao.getDefinedRank(definedRankSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> x_data=new  ArrayList<String>();
        for(int i = 0; i< definedResultList.size(); i++){
            amounts.add(definedResultList.get(i).getAmount());
            x_data.add(definedResultList.get(i).getX_data());
        }
        data.put("amounts",amounts);
        data.put("x_datas",x_data);
        logger.info("查询成功");
        return data;
    }
}
