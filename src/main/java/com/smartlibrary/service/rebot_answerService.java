package com.smartlibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartlibrary.dao.rebot_answerDao;

/**
 * Created by 胡云飞 on 2017/10/18.
 */
@Service
public class rebot_answerService {
@Autowired
private rebot_answerDao rebot_answerDao;
    public String getNumber(String name){
        return rebot_answerDao.getNumber(name);
    }
}
