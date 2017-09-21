package com.smartlibrary.service;

import com.smartlibrary.dao2.UserDao;
import com.smartlibrary.domain2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tt on 2017/9/21.
 */

@Service
public class UserService {
    @Autowired
    private UserDao userdao;
    public List<User> getUser(User u){
        return userdao.getUser(u);
    }
}
