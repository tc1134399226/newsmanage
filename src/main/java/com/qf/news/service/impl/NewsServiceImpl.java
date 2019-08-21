package com.qf.news.service.impl;

import com.qf.news.dao.NewsMapper;
import com.qf.news.service.NewsService;
import com.qf.news.vo.ArticleTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询新闻的信息 地区和类型
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatus() {
        return newsMapper.listAllArticleByStatus();
    }
}
