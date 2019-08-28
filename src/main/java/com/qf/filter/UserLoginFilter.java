package com.qf.filter;

import com.qf.sysuser.pojo.User;
import com.qf.sysuser.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        if (uri.equals("/newsmanage/userInfo.html")) {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            if (userInfo != null) {
                return true;
            }
            httpServletResponse.sendRedirect("http://localhost:8080/newsmanage/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
