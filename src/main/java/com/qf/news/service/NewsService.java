package com.qf.news.service;

import com.qf.news.vo.ArticleTypeVO;

import java.util.List;

public interface NewsService {
    /**
     * 根据最新时间查询新闻的信息 地区 和类型  前5条
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime();

    /**
     * 根据热度查询新闻的信息,地区和类型  前5条
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot();
}
