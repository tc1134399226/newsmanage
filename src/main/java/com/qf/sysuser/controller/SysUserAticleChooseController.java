package com.qf.sysuser.controller;

import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserArticleCarouselService;
import com.qf.sysuser.service.SysUserAticleChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("admin/sysuser")
@RestController
public class SysUserAticleChooseController {

    @Autowired
    SysUserAticleChooseService sysUserAticleChooseService;

    //筛选新闻添加到轮播库并删除最早的新闻,同时改变state为2
    @RequestMapping("addToImg")
    public Object addToImg(@RequestBody ArticleInfo articleInfo){
        List<ArticleCarousel> allArticleByTypeId = sysUserAticleChooseService.getAllArticleByTypeId(articleInfo.getTypeId());

        if (allArticleByTypeId.size()<3){
            return sysUserAticleChooseService.addToImg(articleInfo);

        }else{
            ArticleCarousel article = sysUserAticleChooseService.selectArticleByTypeId(articleInfo.getTypeId());
            boolean b = sysUserAticleChooseService.removeArticleUseId(article.getArticleId());
            System.out.println(b);
            if (b){
                return sysUserAticleChooseService.addToImg(articleInfo);
            }else{
                return false;
            }
        }

    }

    //已加入area_type_img表中的新闻将设置状态为2
    @RequestMapping("updateState")
    public Object updateState(int articleId){
        return sysUserAticleChooseService.updateState(articleId);
    }

    //根据id查询area_type_img表中新闻详情信息
    @RequestMapping("getArticleImgById")
    public Object getArticleImgById(@RequestParam int articleId){
        return sysUserAticleChooseService.getArticleImgById(articleId);
    }
}
