package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentVO {
    private long comId;
    private long userId;
    private String nickName;
    private String content;
    private Integer status;
    private String icon;
    private Timestamp createTime;
}