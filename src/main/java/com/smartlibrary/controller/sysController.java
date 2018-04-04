package com.smartlibrary.controller;

import com.smartlibrary.domain2.Account;
import com.smartlibrary.service.AccountService;
import com.smartlibrary.tools.SHAencrypt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
/**
 * by zhou
 * 8-4
 * 登录
 */
@Controller
@RequestMapping(value={"/sys","/cttp/production/sys"})
public class sysController {
    @Autowired
    private AccountService accountService;
    private static final Logger logger = Logger.getLogger(sysController.class);

    @RequestMapping(value="/logout_logout" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public void logout_logout(HttpSession httpSession){
        httpSession.removeAttribute("SESSION_USER");
    }


    @RequestMapping(value="/login_login" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map login_login(HttpSession httpSession,@RequestParam String loginname,
                           @RequestParam String password,@RequestParam String code){
        Map rMap = new HashMap();
        Account account = new Account();
       Account account1 = new Account();
        String errInfo = "";
        String passwd = "";
        if (null != loginname && null !=password && null != code){

            String session_code = (String)httpSession.getAttribute("SESSION_CODE");
            if(null == code || "".equals(code)){                                        //判断效验码
                errInfo = "nullcode"; 			                                        //效验码为空
            }else{
                if(notEmpty(session_code) && session_code.equalsIgnoreCase(code)) {             //判断登录验证码
                    try {
                        passwd = SHAencrypt.encryptSHA(password);                              //密码加密
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    account.setPassword(passwd);
                    account.setAccount(loginname);
                    account1 = accountService.getAccount(account);
                    if (account1 != null &&  account1.getPassword().equals(passwd)){
                        rMap.put("accountType", account1.getType());                        // 得到用户类型
                        rMap.put("permissionAllocate",account1.getPermision_allocate());    // 得到用户权限
                        httpSession.setAttribute("SESSION_USER", loginname);             //把用户信息放session中
                        httpSession.removeAttribute("SESSION_CODE");                     //清除登录验证码的session
                    } else {
                        errInfo = "usererror";                             //用户名或密码有误
                        logger.info("amdin".equals(loginname));
                        logger.info(loginname == "admin");
                        logger.info(loginname.equals("admin"));
                    }
                }else {
                    errInfo = "codeerror";				 	//验证码输入有误
                }
                if(isEmpty(errInfo)){
                    errInfo = "success";					//验证成功
                }
            }
        }else {
            errInfo = "error";
        }
        rMap.put("result", errInfo);
        return rMap;
    }

    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }

    public static boolean isEmpty(String s){
        return s==null || "".equals(s) || "null".equals(s);
    }
}
