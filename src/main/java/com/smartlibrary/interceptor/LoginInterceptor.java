package com.smartlibrary.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Created by zian on 2017/8/8.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String admin = (String)httpServletRequest.getSession().getAttribute("SESSION_USER");
        if (admin == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.html");
            return false;
        }
        return true;

//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.html");
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
