package com.smartlibrary.controller;

import com.smartlibrary.domain2.app_accountManagement;
import com.smartlibrary.service.app_accountManagementService;
import com.smartlibrary.tools.SHAencrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Creat by XiaoZhang
 */

@Controller
@RequestMapping({ "/accountManage" })
public class app_accountManagementController {
    @Autowired
    private app_accountManagementService app_accountManagementservice;

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public @ResponseBody
    boolean addAccount(@RequestBody app_accountManagement adddate){
        try{
            adddate.setPassword(SHAencrypt.encryptSHA(adddate.getPassword()));
        }catch(Exception e){ }

        System.out.println(adddate.getAccount());
        System.out.println(adddate.getPassword());
        System.out.println(adddate.getType());
        System.out.println(adddate.getPermission_allocate());
        System.out.println(adddate.getSchool_id());
        app_accountManagementservice.add(adddate);
        System.out.println("-----------------------------------");
        return true;
    }
}
