package com.qf.sysuser.vo;

import lombok.Data;

@Data
public class UserVO {
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
