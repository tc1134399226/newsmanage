package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleTypeVO {
    public Integer articleId;
    public Integer typeId;
    private Integer userId;
    private String mainTitle;
    private String subTitle;
    private Timestamp createTime;
    private String areaName;
    private String typeName;
    private Integer hot;
    private String cover;
}
