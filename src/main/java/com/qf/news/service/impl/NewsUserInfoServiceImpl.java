package com.qf.news.service.impl;


import com.qf.news.dao.NewsUserInfoMapper;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsUserInfoServiceImpl implements NewsUserInfoService {
    @Autowired
    NewsUserInfoMapper userInfoMapper;


    public UserInfo loginCheck(UserInfo userInfo) {

        UserInfo userInfo1 = userInfoMapper.loginCheck(userInfo);
        return userInfo1;
    }

    public boolean register(UserInfo userInfo) {
        int register = userInfoMapper.register(userInfo);
        return register>0;
    }

    public UserInfo checkAccount(UserInfo userInfo) {
        UserInfo userId = userInfoMapper.checkAccount(userInfo);
        return  userId;
    }

    public UserInfo getUserInfoById(int id) {
        return this.userInfoMapper.getUserInfoById(id);
    }

    public boolean editUserInfoById(UserInfo userInfo) {
        return this.userInfoMapper.editUserInfoById(userInfo)>0;
    }
}
