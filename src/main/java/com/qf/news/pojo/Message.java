package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Message {
    private Long mgeId;
    private Long userId;
    private Long senderId;
    private String mainTitle;
    private String content;
    private int status;
    private Timestamp createTime;

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
