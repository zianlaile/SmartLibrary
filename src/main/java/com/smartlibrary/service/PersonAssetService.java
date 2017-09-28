package com.smartlibrary.service;

import com.smartlibrary.dao2.PersonAssetDao;
import com.smartlibrary.domain2.Counts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zian on 2017/9/28.
 */
@Service
public class PersonAssetService {
    @Autowired
    PersonAssetDao personAssetDao;

    public List<Counts> getCountsBySex() {

        return  personAssetDao.getCountsBySex();
    }

    public List<Counts> getCountsByYear() {
        return  personAssetDao.getCountsByYear();
    }

    public List<Counts> getAssetCountsByYear() {
        return  personAssetDao.getAssetByYear();
    }

    public List<Counts> getAssetCountsByFloor() {
        return  personAssetDao.getAssetByFloor();
    }
}
