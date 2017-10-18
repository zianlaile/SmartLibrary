package com.smartlibrary.service;
import com.smartlibrary.dao.bigScreenNoticeDao;
import com.smartlibrary.domain2.app_notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/10/18.
 */
@Service
public class bigScreenNoticeService {
    @Autowired
    private bigScreenNoticeDao bigScreenNoticedao;

    public Integer Count(app_notice r){
        return bigScreenNoticedao.count(r);
    }

    public List<app_notice> ShowList(app_notice r){
        return bigScreenNoticedao.showList(r);
    }
    public void add(app_notice adddate){
        bigScreenNoticedao.add(adddate);
    }

    public void deletebyids(List ids){
        bigScreenNoticedao.deletebyids(ids);
    }

    public app_notice getbyid(int id){
        return bigScreenNoticedao.getbyid(id);
    }
    public void update(app_notice data){
        bigScreenNoticedao.update(data);
    }
    public app_notice getnew() {
        app_notice result=bigScreenNoticedao.getnew();
        return result;
    }
}

