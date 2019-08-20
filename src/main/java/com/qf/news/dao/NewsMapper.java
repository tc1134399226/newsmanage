package com.qf.news.dao;

import com.qf.news.vo.ArticleTypeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    /**
     * 根据最新时间查询新闻的信息 地区 和类型  前5条
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime();


    /**
     * 根据最热时间查询新闻的信息 地区 和类型  前5条
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot();
}
