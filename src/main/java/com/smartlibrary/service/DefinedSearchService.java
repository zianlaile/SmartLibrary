package com.smartlibrary.service;

import com.smartlibrary.dao.definedSearchDao;
import com.smartlibrary.domain.DefinedBookResult;
import com.smartlibrary.domain.DefinedBookSearch;
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
    private static final Logger logger = Logger.getLogger(bookLendService.class);
    @Autowired
    private definedSearchDao definedsearchDao;


    public Map<String,List> getDefinedBookSearch(DefinedBookSearch definedBookSearch, Errors errors) {
        Map<String ,List> data=new HashMap<String ,List>();
        if(errors.hasErrors()){
            data.put("error",errors.getFieldErrors());
            return data;
        }
        List<DefinedBookResult> definedBookResultList=definedsearchDao.getDefinedBook(definedBookSearch);
        ArrayList<Integer> amounts=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        for(int i=0;i<definedBookResultList.size();i++){
            /*definedBookResultList.get(i).setTime();*/
            amounts.add(definedBookResultList.get(i).getAmount());
            times.add(String.valueOf(definedBookResultList.get(i).getTime()));
        }
        System.out.println("OK");
        data.put("amounts",amounts);
        data.put("times",times);
        return data;
    }
}
