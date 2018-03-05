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
        String loginnm = "";
        String passwd = "";
        String tempPasswd = "";
        int type;
        if (null != loginname && null !=password && null != code){

            String session_code = (String)httpSession.getAttribute("SESSION_CODE");
            if(null == code || "".equals(code)){//判断效验码
                errInfo = "nullcode"; 			//效验码为空
            }else{
                if(notEmpty(session_code) && session_code.equalsIgnoreCase(code)) {        //判断登录验证码
                    // String passwd = new SimpleHash("SHA-1", loginname, password).toString();	//密码加密

                    try {
                        passwd = SHAencrypt.encryptSHA(password);   //密码加密
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (loginname.equals("admin") && passwd.equals("01e56eeec696129f8f5fef2a30666ce8b56de6ad")) {
                        account1.setAccount(loginname);
                    } else {
                        account.setPassword(passwd);
                        account.setAccount(loginname);
                        account1 = accountService.getAccount(account);
                    }
                        //pd.put("PASSWORD", passwd);
                        //  pd = userService.getUserByNameAndPwd(pd);	//根据用户名和密码去读取用户信息
                        //if("" != null){
                        //if (loginname.equals(loginnm) && passwd.equals("01e56eeec696129f8f5fef2a30666ce8b56de6ad")) {

                    try{
                        tempPasswd =  SHAencrypt.encryptSHA(account1.getPassword());
                        System.out.println(tempPasswd);
                    }catch (Exception e) {
                            e.printStackTrace();
                    }
                        if (account1 != null &&  tempPasswd.equals(passwd)){
                            rMap.put("accountType", account1.getType());
                            httpSession.setAttribute("SESSION_USER", loginname);            //把用户信息放session中
                            httpSession.removeAttribute("SESSION_CODE");                    //清除登录验证码的session
                        } else {
                            errInfo = "usererror";                             //用户名或密码有误
                            logger.info("amdin".equals(loginname));
                            logger.info(loginname == "admin");
                            logger.info(loginname.equals("admin"));
                            // logBefore(logger, USERNAME+"登录系统密码或用户名错误");
                            // FHLOG.save(USERNAME, "登录系统密码或用户名错误");
                        }

                }else {
                    errInfo = "codeerror";				 	//验证码输入有误
                }

                if(isEmpty(errInfo)){
                    errInfo = "success";					//验证成功
                    //logBefore(logger, USERNAME+"登录系统");
                    //FHLOG.save(USERNAME, "登录系统");
                }
            }
        }else {
            errInfo = "error";
        }

//        String ccode = (String) httpSession.getAttribute("SESSION_CODE");
//        System.out.println(loginname+password+code+ccode);
//        rMap.put("ret", 0);
//        rMap.put("info", "登录成功");
//        httpSession.setAttribute("SESSION_USER", loginname);
//        logger.info("checkLoginUser--" + loginname + " login success.");
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
