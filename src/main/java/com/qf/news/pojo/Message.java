package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Message {
    private Long mgeId;
    private Long userId;
    private long senderId;
    private String mainTitle;
    private String content;
    private int status;
    private Timestamp createTime;
    private long repId;
    private long comId;
    private String mgeUrl;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
