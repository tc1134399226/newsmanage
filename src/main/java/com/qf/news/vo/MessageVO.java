package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class MessageVO {
    private Long mgeId;
    private Long userId;
    private Long senderId;
    private String mainTitle;
    private String content;
    private int status;
    private Timestamp createTime;
    private String nickName;
    private long repId;
    private long comId;
    private String mgeUrl;
    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
