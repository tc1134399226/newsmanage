package com.qf.news.pojo;

import lombok.Data;

@Data
public class MenuInfo {
   private int mid;
    private  String menuName;
    private  String menuIcon;
    private  String menuUrl;
    private int parentId;
}
