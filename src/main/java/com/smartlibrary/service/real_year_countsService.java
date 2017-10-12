package com.smartlibrary.service;

import com.smartlibrary.dao.real_year_countsDao;
import com.smartlibrary.domain.real_year_counts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/10/12.
 */
@Service
public class real_year_countsService {
    @Autowired
    private real_year_countsDao real_year_countsdao;

    public List<real_year_counts> ShowList(real_year_counts r){
        return real_year_countsdao.showList(r);
    }

}
