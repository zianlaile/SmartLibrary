package com.smartlibrary.controller;

import com.smartlibrary.domain2.User;
import com.smartlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tt on 2017/9/21.
 */
@Controller
@RequestMapping({ "/getUser" })
public class userController {
    @Autowired
    private UserService userservice;

    @RequestMapping(method = { RequestMethod.GET })
    @ResponseBody
    //post方法测试
    public List<User> getUser(HttpServletRequest request) {
        User u=new User();
        return userservice.getUser(u);
    }
}
