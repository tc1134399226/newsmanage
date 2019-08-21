package com.qf.news.service.impl;

import com.qf.news.dao.NewsMapper;
import com.qf.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qf.news.vo.ArticleTypeVO;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 根据最新时间查询新闻的信息 地区 和类型  前5条
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime() {
        return newsMapper.listAllArticleByStatusByCreateTime();
    }

    /**
     * 根据热度查询新闻的信息,地区和类型  前5条
     * @return
     */

    public List<ArticleTypeVO> listAllArticleByStatusByHot() {
        return newsMapper.listAllArticleByStatusByHot();
    }
}
