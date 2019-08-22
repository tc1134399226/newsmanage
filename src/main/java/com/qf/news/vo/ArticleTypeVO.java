package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleTypeVO {
    public Integer articleId;
    public Integer typeId;
    private Integer userId;
    private String mainTitle;
    private String content;
    private Timestamp createTime;
    private String areaName;
    private String typeName;
    private Long comNum;//评论数
    private Long articleLoveNum;//新闻点赞数
}
