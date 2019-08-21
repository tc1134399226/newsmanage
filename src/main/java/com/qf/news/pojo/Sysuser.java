package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Sysuser {
    private long userId;
    private String account;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String areaCode;
    private String icon;
    private  Integer status;
}
