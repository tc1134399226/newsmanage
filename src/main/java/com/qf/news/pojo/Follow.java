package com.qf.news.pojo;

import com.qf.news.dto.FollowUser;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Follow {
    private Integer followId;
    private Integer userId;
    private Integer repUserId;
    private Timestamp createTime;
    List<FollowUser> myFollows;
    List<FollowUser> myFances;
}
