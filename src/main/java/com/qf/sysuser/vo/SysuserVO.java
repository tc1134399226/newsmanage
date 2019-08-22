package com.qf.sysuser.vo;

import lombok.Data;

import java.util.List;

@Data
public class SysuserVO {
    private long userId;
    private String account;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String areaCode;
    private String icon;
    private  Integer status;
    private List<RoleInfoVO> roleInfoVOS;
}
