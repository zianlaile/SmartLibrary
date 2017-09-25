package com.smartlibrary.service;

import com.smartlibrary.dao2.app_noticeDao;
import com.smartlibrary.domain2.app_notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tt on 2017/9/23.
 */
@Service
public class app_noticeService {
    @Autowired
    private app_noticeDao app_noticedao;

    public Integer Count(app_notice bs){
        return app_noticedao.count(bs);
    }

    public List<app_notice> ShowList(app_notice bs){
        return app_noticedao.showList(bs);
    }
    public void addn(app_notice adddate){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        adddate.setTime(df.format(new Date()));
        app_noticedao.addn(adddate);
    }

    public void deletebyids(List ids){
        app_noticedao.deletebyids(ids);
    }

    public app_notice getnbyid(int id){
        return app_noticedao.getnbyid(id);
    }
    public void updaten(app_notice data){
        app_noticedao.updaten(data);
    }
    public void updaten_picurl(app_notice data){
        app_noticedao.updaten_picurl(data);
    }
}
