package com.qf.sysuser.dao;

import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;

import java.util.List;

public interface SysUserArticleCarouselMapper {

    //通过封面图筛选新闻
    List<ArticleInfo> getArticleByCover(ArticleInfo articleInfo);

    //筛选新闻添加到轮播库
    int addToCarousel(ArticleInfo articleInfo);

    //已加入轮播的新闻将设置状态为1
    int updateArticleState(int articleId);

    //查询所有轮播新闻信息
    List<ArticleCarousel> getAllArticleCarousel();


    //查询最早添加的新闻id
    ArticleCarousel selectArticleId();

    //根据这个id删除掉这条新闻信息
    int deleteArticleUseId(int articleId);

    //根据id查询轮播新闻详情信息
    ArticleCarousel getArticleCarouselById(int articleId);
}
