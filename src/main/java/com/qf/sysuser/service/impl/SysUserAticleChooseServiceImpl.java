package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysUserArticleChooseMapper;
import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserAticleChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserAticleChooseServiceImpl implements SysUserAticleChooseService {

    @Autowired
    SysUserArticleChooseMapper sysUserArticleChooseMapper;

    //添加筛选新闻到area_type_img表中
    public boolean addToImg(ArticleInfo articleInfo) {
        return sysUserArticleChooseMapper.addToImg(articleInfo)>0;
    }

    //已加入area_type_img表中的新闻将设置状态为2
    public boolean updateState(int articleId) {
        return sysUserArticleChooseMapper.updateState(articleId)>0;
    }

    //根据类型查询所有area_type_img表中该类型新闻信息
    public List<ArticleCarousel> getAllArticleByTypeId(int typeId) {
        return sysUserArticleChooseMapper.getAllArticleByTypeId(typeId);
    }

    //根据类型查询最早添加的新闻id
    public ArticleCarousel selectArticleByTypeId(int typeId) {
        return sysUserArticleChooseMapper.selectArticleByTypeId(typeId);
    }

    //根据这个id删除掉这条新闻信息
    public boolean removeArticleUseId(int articleId) {
        return sysUserArticleChooseMapper.removeArticleUseId(articleId)>0;
    }

    //根据id查询area_type_img表中新闻详情信息
    public ArticleCarousel getArticleImgById(int articleId) {
        return sysUserArticleChooseMapper.getArticleImgById(articleId);
    }
}
