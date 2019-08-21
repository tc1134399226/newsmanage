package com.qf.sysuser.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfoVO {
   private int mid;
    private  String menuName;
    private  String menuIcon;
    private  String menuUrl;
    private int parentId;
    List<MenuInfoVO> childMenus;
    List<RoleInfoVO> roleInfoList;
}
