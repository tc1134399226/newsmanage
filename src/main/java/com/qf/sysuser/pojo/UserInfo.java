package com.qf.sysuser.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserInfo {

    Integer userId;
    String account;
    String nickName;
    String password;
    String idCard;
    String mobile;
    String realName;
    String idCardBack;
    String idCardFront;
    String sex;
    String icon;
    Integer status;
    Timestamp createTime;
    Timestamp updateTime;


}
