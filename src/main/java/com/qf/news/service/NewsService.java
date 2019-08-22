package com.qf.news.service;

import com.qf.news.vo.ArticleTypeVO;

import java.util.List;

public interface NewsService {
    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime();


    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot();
}
