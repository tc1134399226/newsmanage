package com.qf.news.dao;


import com.qf.news.pojo.UserInfo;

import java.util.List;

public interface NewsUserInfoMapper {

    public UserInfo loginCheck(UserInfo userInfo);

    public int register(UserInfo userInfo);

    public UserInfo checkAccount(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    public int editUserInfoById(UserInfo userInfo);

//    public List<MenuInfoVO> userLoginInit(UserInfo userInfo);
}

