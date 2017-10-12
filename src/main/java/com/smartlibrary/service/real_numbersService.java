package com.smartlibrary.service;

import com.smartlibrary.dao.real_numbersDao;
import com.smartlibrary.domain.real_numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/10/12.
 */
@Service
public class real_numbersService {
    @Autowired
    private real_numbersDao real_numbersdao;
    public List<real_numbers> ShowList(real_numbers r){
        return real_numbersdao.showList(r);
    }
}
