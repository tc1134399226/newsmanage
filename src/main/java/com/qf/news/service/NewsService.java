package com.qf.news.service;

import com.qf.news.vo.ArticleTypeVO;

import java.util.List;

public interface NewsService {
    /**
     * 查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatus();
}
