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
        return newsService.listAllArticleByStatus();
    }


    /**
     *  根据热度查询新闻的信息,地区和类型
     * @return
     */
    @RequestMapping("listAllArticleByStatusByHot")
    @ResponseBody
    public Object listAllArticleByStatusByHot(){
        return newsService.listAllArticleByStatus();
    }
}
