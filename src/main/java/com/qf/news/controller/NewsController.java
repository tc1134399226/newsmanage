package com.qf.news.controller;


import com.qf.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
