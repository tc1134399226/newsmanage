package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    public Integer articleId; //新闻id
    public Integer typeId;  //新闻类型
    private Integer userId;  //用户id
    private String mainTitle;  //主标题
    private String subTitle;  //副标题
    private String content;  //内容
    private Integer status;  //状态
    private Timestamp createTime;  //创建时间
    private Timestamp updateTime;  //更新时间
    private String userIp;  //用户ip地址
}
