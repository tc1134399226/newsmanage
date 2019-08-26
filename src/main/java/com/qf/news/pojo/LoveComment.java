package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class LoveComment {
private long lcId;
private long userId;
private long comId;
private int status;
private Timestamp createTime;
private Timestamp updateTime;

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime.toString();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
