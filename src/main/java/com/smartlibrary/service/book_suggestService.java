package com.smartlibrary.service;

import com.smartlibrary.dao2.book_suggestDao;
import com.smartlibrary.domain2.app_book_suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by tt on 2017/9/22.
 */
@Service
public class book_suggestService {
    @Autowired
    private book_suggestDao book_suggestdao;

    public Integer Count(app_book_suggest bs){
        return book_suggestdao.count(bs);
    }

    public List<app_book_suggest> ShowList(app_book_suggest bs){
        return book_suggestdao.showList(bs);
    }
    public void addbs(app_book_suggest adddate){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        adddate.setTime(df.format(new Date()));
        book_suggestdao.addbs(adddate);
    }

    public void deletebyids(List ids){
         book_suggestdao.deletebyids(ids);
    }

    public app_book_suggest getbsbyid(int id){
        return book_suggestdao.getbsbyid(id);
    }
    public void updatebs(app_book_suggest data){
         book_suggestdao.updatebs(data);
    }
}
