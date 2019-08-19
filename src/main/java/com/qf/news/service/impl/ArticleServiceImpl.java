package com.qf.news.service.impl;


import com.qf.news.dao.ArticleMapper;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    /**
     * 通过UserInfo参数中的UserId获取我的文章(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyArtByUserId(UserInfo userInfo) {
        return articleMapper.getMyArtByUserId(userInfo);
    }

    /**
     * 通过UserInfo参数中的UserId获取我的草稿(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyDraftByUserId(UserInfo userInfo) {
        return articleMapper.getMyDraftByUserId(userInfo);
    }

    /**
     * 通过ArticleId删除我的草稿
     * @param articleId
     * @return
     */
    public boolean deleteMyDraftByArticleId(Long articleId) {
        return articleMapper.deleteMyDraftByArticleId(articleId)>0;
    }
}
