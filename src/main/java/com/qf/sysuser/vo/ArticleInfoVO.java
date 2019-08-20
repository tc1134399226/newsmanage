package com.qf.sysuser.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleInfoVO {

    Integer articleId;
    Integer userId;
    Integer typeId;
    String cover;
    String mainTitle;
    String subTitle;
    String content;
    Integer status;
    Timestamp creatTime;
    Timestamp updateTime;
    String typeName;

}
