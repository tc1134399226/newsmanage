package com.qf.news.vo;

import java.sql.Timestamp;

public class ReplyVO {
    private long repId;
    private long comId;
    private long userId;//发送消息的人
    private String nickName;
    private long parentId;//被回复消息id
    private String content;//回复内容
    private Integer status;
    private String icon;
    private long crepId;
    private long cuserId;//被人回复人id
    private String cnickName;
    private String ccontent;//被回复内容
    private Timestamp createTime;
    private String mainTitle;
    private String mgeUrl;

    public String getMgeUrl() {
        return mgeUrl;
    }

    public void setMgeUrl(String mgeUrl) {
        this.mgeUrl = mgeUrl;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public long getRepId() {
        return repId;
    }

    public void setRepId(long repId) {
        this.repId = repId;
    }

    public long getComId() {
        return comId;
    }

    public void setComId(long comId) {
        this.comId = comId;
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


    public long getCrepId() {
        return crepId;
    }

    public void setCrepId(long crepId) {
        this.crepId = crepId;
    }

    public long getCuserId() {
        return cuserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCuserId(long cuserId) {
        this.cuserId = cuserId;
    }

    public String getCnickName() {
        return cnickName;
    }

    public void setCnickName(String cnickName) {
        this.cnickName = cnickName;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ReplyVO{" +
                "repId=" + repId +
                ", comId=" + comId +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", icon='" + icon + '\'' +
                ", crepId=" + crepId +
                ", cuserId=" + cuserId +
                ", cnickName='" + cnickName + '\'' +
                ", ccontent='" + ccontent + '\'' +
                ", createTime=" + createTime +
                ", mainTitle='" + mainTitle + '\'' +
                ", mgeUrl='" + mgeUrl + '\'' +
                '}';
    }
}
