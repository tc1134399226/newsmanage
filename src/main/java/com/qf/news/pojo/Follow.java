package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Follow {
    private Integer followId;
    private Integer userId;
    private Integer repUserId;
    private Timestamp createTime;
}
