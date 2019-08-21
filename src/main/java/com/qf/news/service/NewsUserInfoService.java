package com.qf.news.service;


import com.qf.news.pojo.UserInfo;

public interface NewsUserInfoService {


    public UserInfo loginCheck(UserInfo userInfo);

    public boolean register(UserInfo userInfo);

    public UserInfo checkAccount(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    public boolean editUserInfoById(UserInfo userInfo);
}
