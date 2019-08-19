package com.qf.news.vo;

import java.sql.Timestamp;

public class CollectionVO {
    public Long colId;
    public Long userId;
    public Long articleId;
    private Timestamp colTime;
    private Integer areaId;
    private String articleName;
    private long typeId;
    private String mainTitle;
    private String subTitle;
    private String content;
    private Timestamp artTime;

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

    public String  getColTime() {
        return colTime.toString();
    }

    public void setColTime(Timestamp colTime) {
        this.colTime = colTime;
    }

    public Integer getAreaId() {
//        if (areaId==2){
//            return "内地";
//        }else if (areaId==3){
//            return "港澳";
//        }else if (areaId==4){
//            return "台湾";
//        }
//        return "国际";
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArtTime() {
        return artTime.toString();
    }

    public void setArtTime(Timestamp artTime) {
        this.artTime = artTime;
    }

    @Override
    public String toString() {
        return "CollectionVO{" +
                "colId=" + colId +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", colTime=" + colTime +
                ", areaId=" + areaId +
                ", articleName='" + articleName + '\'' +
                ", typeId=" + typeId +
                ", mainTitle='" + mainTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", content='" + content + '\'' +
                ", artTime=" + artTime +
                '}';
    }
}
