package com.qf.news.service.impl;


import com.qf.news.dao.NewsArticleMapper;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements NewsArticleService {

    @Qualifier("newsArticleMapper")
    @Autowired
    NewsArticleMapper newsArticleMapper;

    /**
     * 通过UserInfo参数中的UserId获取我的文章(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyArtByUserId(UserInfo userInfo) {
        return newsArticleMapper.getMyArtByUserId(userInfo);
    }

    /**
     * 通过UserInfo参数中的UserId获取我的草稿(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyDraftByUserId(UserInfo userInfo) {
        return newsArticleMapper.getMyDraftByUserId(userInfo);
    }

    /**
     * 通过ArticleId删除我的草稿
     * @param articleId
     * @return
     */
    public boolean deleteMyDraftByArticleId(Long articleId) {
        return newsArticleMapper.deleteMyDraftByArticleId(articleId)>0;
    }
}
