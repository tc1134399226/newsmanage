package com.qf.news.service;

import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.UserInfo;

import java.util.List;

public interface ArticleService {
    /**
     * 通过UserInfo参数中的UserId获取我的文章(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyArtByUserId(UserInfo userInfo);

    /**
     * 通过UserInfo参数中的UserId获取我的草稿(分页)
     * @param userInfo
     * @return
     */
    public List<ArticleInfo> getMyDraftByUserId(UserInfo userInfo);

    /**
     * 通过ArticleId删除我的草稿
     * @param articleId
     * @return
     */
    public boolean  deleteMyDraftByArticleId(Long articleId);
}
