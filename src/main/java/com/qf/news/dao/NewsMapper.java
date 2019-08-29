package com.qf.news.dao;

import com.qf.news.vo.AreaTypeVO;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.sysuser.pojo.ArticleCarousel;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * 获取轮播图
     * @return
     */
    public List<ArticleTypeVO> getMainImg();

    /**
     * 获取指定类型和地区的文章
     * @param typeId
     * @param areaId
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByTypeIdAndAreaId(Integer typeId,Integer areaId);
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

    //根据id查询轮播新闻详情信息
    public List<ArticleTypeVO> getArticleCarousel();
}
