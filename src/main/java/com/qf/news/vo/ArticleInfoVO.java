package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class ArticleInfoVO {
    private long articleId;
    private Integer areaId;
    private long userId;
    private long typeId;
    private String mainTitle;
    private String subTitle;
    private String content;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String userIp;
    private String cover;
    private Integer state = 0; //后台轮播图状态  新加
    private String nickName;
    private String icon;
}
