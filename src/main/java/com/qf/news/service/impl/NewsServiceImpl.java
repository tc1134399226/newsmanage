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
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime() {
        return newsMapper.listAllArticleByStatusByCreateTime();
    }


    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot() {
        return newsMapper.listAllArticleByStatusByHot();
    }

    /**
     * 获取轮播图
     * @return
     */
    public List<ArticleTypeVO> getMainImg() {
        return newsMapper.getMainImg();
    }
}
