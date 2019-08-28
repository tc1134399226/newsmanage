package com.qf.news.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.service.NewsService;
import com.qf.news.vo.ArticleTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("news")
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     *  根据最新时间查询新闻的信息 地区 和类型
     * @return
     */
    @RequestMapping("listAllArticleByStatusByCreateTime")
    @ResponseBody
    public Object listAllArticleByStatusByCreateTime(){
        return newsService.listAllArticleByStatusByCreateTime();
    }


    /**
     * 通过创建时间查询所有审核已通过的新闻
     * @return
     */
    @RequestMapping("listAllArticleByStatusByHot")
    @ResponseBody
    public Object listAllArticleByStatusByHot(){
        return newsService.listAllArticleByStatusByHot();
    }

    /**
     * 获取轮播图
     * @return
     */
    @RequestMapping("getMainImg")
    @ResponseBody
    public Object getMainImg(){
        return newsService.getMainImg();
    }

    /**
     * 获取指定类型和地区的文章 按照热度降序
     * @param typeId
     * @param areaId
     * @return
     */
    @RequestMapping("listAllArticleByStatusAndHotAndTypeIdAndAreaId")
    @ResponseBody
    public Object listAllArticleByStatusAndHotAndTypeIdAndAreaId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                          Integer pageNum , Integer typeId, Integer areaId){
        System.out.println(typeId);
        System.out.println(areaId);
        if (typeId==0||areaId==0){
            return false;
        }
        //一页有多少条数据
        int defaultPageSize=5;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ArticleTypeVO> articleTypeVOS =
                newsService.listAllArticleByStatusAndHotAndTypeIdAndAreaId(typeId, areaId);
        System.out.println("111"+articleTypeVOS);
        PageInfo<ArticleTypeVO> articleTypeVoPageInfo = new PageInfo<ArticleTypeVO>(articleTypeVOS);
        return articleTypeVoPageInfo;
    }


    @RequestMapping("listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId")
    @ResponseBody
    public Object listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
           Integer pageNum , Integer typeId, Integer areaId){

        System.out.println(typeId);
        System.out.println(areaId);
        if (typeId==0||areaId==0){
            return false;
        }
        //一页有多少条数据
        int defaultPageSize=5;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ArticleTypeVO> articleTypeVOS =
                newsService.listAllArticleByStatusAndCreateTimeAndTypeIdAndAreaId(typeId, areaId);
        System.out.println(articleTypeVOS);
        PageInfo<ArticleTypeVO> articleTypeVoPageInfo = new PageInfo<ArticleTypeVO>(articleTypeVOS);
        System.out.println(articleTypeVOS);
        return articleTypeVoPageInfo;
    }
}
