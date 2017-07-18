package com.smartlibrary.service;

import com.smartlibrary.dao.bookLendDao;
import com.smartlibrary.domain.Book_Lend;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/7/17.
 */
@Service
public class bookLendService {
    private static final Logger logger = Logger.getLogger(bookLendService.class);
    @Autowired
    private bookLendDao booklenddao;


    public Map<String,List> getBorrowCountByYear(Book_Lend b) {
        List<Book_Lend> year= booklenddao.getBorrowCountByYear(b);
        ArrayList<Integer> lend_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<year.size();i++){
            lend_times.add(year.get(i).getBook_lend_times());
            times.add(String.valueOf(year.get(i).getYear()));
        }
        data.put("lend_times",lend_times);
        data.put("times",times);
        return data;
    }

    public Map<String ,List>  getBorrowCountByMonth(Book_Lend b){
        List<Book_Lend> month= booklenddao.getBorrowCountByMonth(b);
        Book_Lend bl;
        ArrayList<Integer> lend_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<month.size();i++){
            bl=month.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"/"+String.valueOf(bl.getMonth()));
            //组成返回对象X轴与Y轴
            lend_times.add(month.get(i).getBook_lend_times());
            times.add(month.get(i).getTime());
        }
        data.put("lend_times",lend_times);
        data.put("times",times);
        return data;
    }
}
