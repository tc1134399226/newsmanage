package com.qf.sysuser.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.sysuser.pojo.ArticleCarousel;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserArticleCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("admin/sysuser")
@RestController
public class SysUserArticleCarouselController {
    @Autowired
    SysUserArticleCarouselService sysUserArticleCarouselService;

    //根据封面图筛选新闻
    @RequestMapping("getArticleByCover")
    public Object getArticleByCover(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum, @RequestBody ArticleInfo articleInfo){
        int pageSize=3;//每页显示记录数
        System.out.println(articleInfo);
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请的文章信息
        List<ArticleInfo> articleByCover = sysUserArticleCarouselService.getArticleByCover(articleInfo);
        //将获取的ArticleInfo信息封装到PageInfo中
        PageInfo<ArticleInfo> ArticleInfoPageInfo = new PageInfo<ArticleInfo>(articleByCover);
        return ArticleInfoPageInfo;
    }



    //筛选新闻添加到轮播库并删除最早的新闻
    @RequestMapping("addToCarousel")
    public Object addToCarousel(@RequestBody ArticleInfo articleInfo){
        List<ArticleCarousel> allArticleCarousel = sysUserArticleCarouselService.getAllArticleCarousel();

        if (allArticleCarousel.size()<5){
            return sysUserArticleCarouselService.addToCarousel(articleInfo);
        }else{
            ArticleCarousel articleCarousel = sysUserArticleCarouselService.selectArticleId();
            boolean b = sysUserArticleCarouselService.deleteArticleUseId(articleCarousel.getArticleId());
            if (b){
                return sysUserArticleCarouselService.addToCarousel(articleInfo);
            }else{
                return false;
            }
        }
    }


    //已加入轮播的新闻将设置状态为1
    @RequestMapping("updateArticleState")
    public Object updateArticleState(@RequestParam int articleId){
        return sysUserArticleCarouselService.updateArticleState(articleId);
    }

    //查询所有轮播新闻信息
    @RequestMapping("getAllArticleCarousel")
    public Object getAllArticleCarousel(){
        return sysUserArticleCarouselService.getAllArticleCarousel();
    }
}
