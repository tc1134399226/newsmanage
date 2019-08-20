package com.qf.sysuser.pojo;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleInfo {

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

}
