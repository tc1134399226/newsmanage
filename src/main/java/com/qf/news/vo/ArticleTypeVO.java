package com.qf.news.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleTypeVO {
    public Integer articleId;
    public Integer typeId;
    private Integer userId;
    private String mainTitle;
    private String subTitle;
    private Timestamp createTime;
    private String areaName;
    private String typeName;
    private Long hot;//总热度
    private Long comNum;//评论数
    private Long articleLoveNum;//新闻点赞数
    private Integer articleLoveStatus;
    private Integer areaId;
    private String content;
    private Integer status;
    private Timestamp updateTime;
    private String userIp;
    private String cover;
    private Integer state = 0; //后台轮播图状态  新加
//用于计算实时热度
    private long timeHot;    //三天内热度
    private Long timeComNum;//评论数
    private Long timeArticleLoveNum;//新闻点赞数

    public long getTimeHot() {
        if (getTimeComNum()==null&&getTimeArticleLoveNum()==null){
            return this.timeHot;
        }
        return getTimeComNum()*10+getTimeArticleLoveNum();
    }

    public void setTimeHot(long timeHot) {
        this.timeHot = timeHot;
    }

    public Long getHot() {
        if (getComNum()==null&&getArticleLoveNum()==null){
            return this.hot;
        }
        return getComNum()*10+getArticleLoveNum();
    }

    public void setHot(long hot) {
        this.hot = hot;
    }

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
