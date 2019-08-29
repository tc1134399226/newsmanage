package com.qf.news.service.impl;

import com.qf.news.dao.NewsArticleInfoMapper;
import com.qf.news.dao.NewsMapper;
import com.qf.news.service.NewsService;
import com.qf.news.vo.AreaTypeVO;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.sysuser.pojo.ArticleCarousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;



    /**
     * 通过创建时间查询所有审核已通过的新闻
     * 查询新闻的信息 地区和类型
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusByCreateTime() {
        return newsMapper.listAllArticleByStatusByCreateTime();
    }


    /**
     * 查询所有的文章按照热度排序
     * @return
     */
    @Transactional
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

    /**
     * 获取指定类型和地区的文章 按照热度降序
     * @param typeId
     * @param areaId
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusAndHotAndTypeIdAndAreaId(Integer typeId, Integer areaId) {
        return newsMapper.listAllArticleByStatusAndHotAndTypeIdAndAreaId(typeId,areaId);
    }
    /**
     * 获取指定类型和地区的文章 按照创建时间降序
     * @param typeId
     * @param areaId
     * @return
     */
    public List<ArticleTypeVO> listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId(Integer typeId, Integer areaId) {
        return newsMapper.listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId(typeId,areaId);
    }


    public AreaTypeVO getAreaIdTypeId(AreaTypeVO areaTypeVO){
        return newsMapper.getAreaIdTypeId(areaTypeVO);
    }

    public  List<ArticleTypeVO>  getArticleCarousel(){
        return newsMapper.getArticleCarousel();
    }
}
