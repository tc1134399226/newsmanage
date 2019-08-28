package com.qf.sysuser.pojo;

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
}
