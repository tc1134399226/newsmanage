package com.qf.news.controller;


import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NewsUserInfoController {

    //自动注入
    @Autowired
    NewsUserInfoService userInfoService;

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
            System.out.println(userInfo1);
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


    //头像上传存储
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        System.out.println("inner upload");
        Map<String, Object> result = new HashMap<String, Object>();

        //创建文件需要存储的路径
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        //如果目标文件夹不存在我就创建它
        if(!destPath.exists()){
            destPath.mkdirs();
        }
        //获取文件的后缀名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));

        String destFileName = UUID.randomUUID()+fileSuffix;
        System.out.println(destFileName);
        File destFile = new File(destPath,destFileName);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);
        result.put("status",200);
        //http://localhost:8080/xxxxx/xxxx.jpg
        result.put("filePath","http://localhost:8080/static/upload/"+destFileName);
        return result;
    }




}
