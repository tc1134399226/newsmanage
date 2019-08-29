package com.qf.news.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class LoveArticle {
    private Long laId;
    private Long userId;
    private Long articleId;
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
