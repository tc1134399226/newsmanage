package com.qf.news.pojo;

import java.sql.Timestamp;

public class CollectionInfo {
    public Long colId;
    public Long userId;
    public Long articleId;
    private  Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Long getColId() {
        return colId;
    }

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "colId=" + colId +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
