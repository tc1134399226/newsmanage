package com.qf.news.dto;

import com.qf.news.pojo.Follow;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class FollowUser {
    private Integer userId;
    private Integer repUserId;
    private String nickName;
    private Timestamp createTime;
    private String icon;
}
