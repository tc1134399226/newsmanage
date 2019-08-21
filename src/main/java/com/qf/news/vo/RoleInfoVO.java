package com.qf.news.vo;

import com.qf.news.pojo.Sysuser;
import lombok.Data;

import java.util.List;

@Data
public class RoleInfoVO {
    private int roleid;
    private  String rolename;
    private  String shortname;
    private  List<MenuInfoVO> menuInfoList;
    private   List<Sysuser> userInfoList;
}
