package com.qf.sysuser.vo;

import com.qf.news.pojo.Sysuser;
import lombok.Data;

import java.util.List;

@Data
public class RoleInfoVO {
    int roleid;
    String rolename;
    String shortname;
    boolean selected;
    private List<MenuInfoVO> menuInfoList;
    private   List<Sysuser> userInfoList;
}
