package com.qf.sysuser.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer userid;
    private String username;
    private String password;
    private String account;
    private String email;
    private String mobile;
    private String areaCode;
    private Integer status;
    private String icon;
}
