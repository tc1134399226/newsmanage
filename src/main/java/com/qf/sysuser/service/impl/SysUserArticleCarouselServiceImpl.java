package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysUserArticleCarouselMapper;
import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserArticleCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserArticleCarouselServiceImpl implements SysUserArticleCarouselService {

    @Autowired
    SysUserArticleCarouselMapper sysUserArticleCarouselMapper;


    //根据封面图筛选新闻
    public List<ArticleInfo> getArticleByCover(ArticleInfo articleInfo) {
        return sysUserArticleCarouselMapper.getArticleByCover(articleInfo);
    }

    //筛选的新闻添加到轮播库
    public boolean addToCarousel(ArticleInfo articleInfo) {
        return sysUserArticleCarouselMapper.addToCarousel(articleInfo)>0;
    }

    //已加入轮播的新闻将设置状态为1
    public boolean updateArticleState(int articleId) {
        return sysUserArticleCarouselMapper.updateArticleState(articleId)>0;
    }

            //查询所有轮播新闻信息
            public List<ArticleCarousel> getAllArticleCarousel() {
                return sysUserArticleCarouselMapper.getAllArticleCarousel();
            }

            //查询最早添加的新闻id
            public ArticleCarousel selectArticleId() {
                return sysUserArticleCarouselMapper.selectArticleId();
            }

            //根据这个id删除掉这条新闻信息
            public boolean deleteArticleUseId(int articleId) {
                return sysUserArticleCarouselMapper.deleteArticleUseId(articleId)>0;
            }

            //根据id查询轮播新闻详情信息
            public ArticleCarousel getArticleCarouselById(int articleId) {
                return sysUserArticleCarouselMapper.getArticleCarouselById(articleId);
    }
}
