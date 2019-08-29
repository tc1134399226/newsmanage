package com.qf.sysuser.vo;

import java.sql.Timestamp;

public class ReportVO {
    Integer userId;
    Integer articleId;
    String nickName;
    String mainTitle;
    Timestamp createTime;
    String context;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


    @Override
    public String toString() {
        return "ReportVO{" +
                "userId=" + userId +
                ", articleId=" + articleId +
                ", nickName='" + nickName + '\'' +
                ", mainTitle='" + mainTitle + '\'' +
                ", createTime=" + createTime +
                ", context='" + context + '\'' +
                '}';
    }
}
