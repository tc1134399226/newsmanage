package com.qf.news.service;

import com.qf.news.pojo.Follow;
import com.qf.news.vo.AreaTypeVO;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.sysuser.pojo.ArticleCarousel;

import java.util.List;

public interface NewsService {
    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime();


    /**
     * 所有审核已通过的新闻根据热度降序
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByHot();

    /**
     * 获取轮播图
     * @return
     */
    public List<ArticleTypeVO> getMainImg();

    /**
     * 获取指定类型和地区的文章 按照热度降序
     * @param typeId
     * @param areaId
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusAndHotAndTypeIdAndAreaId(Integer typeId,Integer areaId);
    /**
     * 获取指定类型和地区的文章 按照创建时间降序
     * @param typeId
     * @param areaId
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId(Integer typeId,Integer areaId);

    public AreaTypeVO getAreaIdTypeId(AreaTypeVO areaTypeVO);

    public List<ArticleTypeVO> getArticleCarousel();

    public Follow getisFollow(Follow follow);

    public int insertFollow(Follow follow);

    public int deleteFollow(Follow follow);

    public List<Follow>  getMyFollow(Follow follow);

    public List<Follow> getMyFance(Follow follow);
}

