package com.qf.filter;

import com.qf.sysuser.pojo.User;
import com.qf.sysuser.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        if ("/newsmanage/login.html".equals(uri)||"/newsmanage/reg.html".equals(uri)){
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("userInfo");
        UserInfo userInfo = (UserInfo) session.getAttribute("sysUser");
        System.out.println(user+""+userInfo);
        if (user!=null||userInfo!=null){
            return true;
        }
        httpServletRequest.getRequestDispatcher("login.html").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
