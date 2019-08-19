package com.qf.news.pojo;

import java.sql.Timestamp;

public class ReplyInfo {
    private long repId;
    private long comId;
    private long userId;
    private String nickName;
    private long parentId;
    private String content;
    private Integer Status;
    private Timestamp createTime;

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public long getComId() {
        return comId;
    }

    public void setComId(long comId) {
        this.comId = comId;
    }

    public long getRepId() {
        return repId;
    }

    public void setRepId(long repId) {
        this.repId = repId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "repId=" + repId +
                ", comId=" + comId +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", Status=" + Status +
                ", createTime=" + createTime +
                '}';
    }
}
