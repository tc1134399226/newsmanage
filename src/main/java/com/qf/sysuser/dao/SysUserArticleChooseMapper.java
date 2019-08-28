package com.qf.sysuser.dao;

import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;

import java.util.List;

public interface SysUserArticleChooseMapper {

    //添加筛选新闻到area_type_img表中
    int addToImg(ArticleInfo articleInfo);

    //已加入area_type_img表中的新闻将设置状态为2
    int updateState(int articleId);

    //根据类型查询所有area_type_img表中该类型新闻信息
    List<ArticleCarousel> getAllArticleByTypeId(int typeId);


    //根据类型查询最早添加的新闻id
    ArticleCarousel selectArticleByTypeId(int typeId);

    //根据这个id删除掉这条新闻信息
    int removeArticleUseId(int articleId);

    //根据id查询area_type_img表中新闻详情信息
    ArticleCarousel getArticleImgById(int articleId);
}
