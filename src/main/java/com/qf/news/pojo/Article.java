package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    public Integer articleId;
    public Integer typeId;
    private Integer userId;
    private String mainTitle;
    private String subTitle;
    private String content;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String userIp;
}
