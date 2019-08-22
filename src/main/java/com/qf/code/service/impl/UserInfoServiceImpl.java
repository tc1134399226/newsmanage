package com.qf.code.service.impl;

import com.qf.dao.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


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
