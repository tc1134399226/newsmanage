package com.qf.news.dao;

import com.qf.news.vo.ArticleTypeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    /**
     * 查询新闻的信息 地区和类型
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime();


    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot();
}
