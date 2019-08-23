package com.qf.news.controller;


import com.qf.news.pojo.UserInfo;
import com.qf.news.service.AliyunSmsService;
import com.qf.news.service.NewsUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("news")
public class NewsUserInfoController {

    //自动注入
    @Autowired
    NewsUserInfoService userInfoService;
    @Autowired
    AliyunSmsService aliyunSmsService;

    /**
     * 用户登录，并将用户信息放入session
     * @param userInfo
     * @param session
     * @return
     */
    @RequestMapping("loginCheck")
    public Object loginCheck(@RequestBody UserInfo userInfo, HttpSession session){

        UserInfo userInfo1 = userInfoService.loginCheck(userInfo);
        //登录成功
        if(userInfo1!=null){
            session.setAttribute("userInfo",userInfo1);
        }else{
            //登录失败
        }
        return userInfo1;
    }
    //用户注册
    @RequestMapping("registerUserInfo")
    public Object registerUserInfo(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        boolean register = userInfoService.register(userInfo);
        return register;
    }

    //注册过程中检查账号是否重复
    @RequestMapping("checkAccount")
    public Object checkAccount(@RequestBody UserInfo userInfo){
//        System.out.println(userInfo);
        UserInfo userId =userInfoService.checkAccount(userInfo);
        return  userId;
    }


    @RequestMapping("getUserInfoById")
    public Object getUserInfoById(@RequestParam int userId){
        System.out.println("id="+userId);
        return this.userInfoService.getUserInfoById(userId);
    }

    @RequestMapping("editUserInfoById")
    public boolean editUserInfoById(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return this.userInfoService.editUserInfoById(userInfo);
    }

    //生成并获取手机验证码
    @RequestMapping("getVerifyCode")
    public Object getPhoneCode(@RequestParam String mobile){
        if (mobile==null&&mobile==""){
            return  false;

        }
        String str = aliyunSmsService.getPhonemsg(mobile);
        return str;

    }

    @RequestMapping("getSession")
    public Object getSession(HttpSession session){
        Object user = session.getAttribute("userInfo");
        return user;
    }

}
