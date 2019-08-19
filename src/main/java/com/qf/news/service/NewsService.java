package com.qf.news.service;

import com.qf.news.pojo.Article;
import com.qf.news.vo.ArticleTypeVo;

import java.util.List;

public interface NewsService {
    /**
     * 查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVo> listAllArticleByStatus();
}
