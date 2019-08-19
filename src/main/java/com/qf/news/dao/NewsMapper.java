package com.qf.news.dao;

import com.qf.news.pojo.Article;
import com.qf.news.vo.ArticleTypeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    /**
     * 查询新闻的信息 地区和类型
     * @return
     */
    public List<ArticleTypeVo> listAllArticleByStatus();
}
