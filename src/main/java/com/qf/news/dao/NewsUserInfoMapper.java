package com.qf.news.dao;


import com.qf.news.pojo.UserInfo;

public interface NewsUserInfoMapper {

    public UserInfo loginCheck(UserInfo userInfo);

    public int register(UserInfo userInfo);

    public UserInfo checkAccount(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    public int editUserInfoById(UserInfo userInfo);
}

