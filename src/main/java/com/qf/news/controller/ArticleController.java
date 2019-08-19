package com.qf.news.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 通过UserId获取我的文章(分页)
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping("getMyArtByUserId")
    public Object getMyArtByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                                Integer pageNum , HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

//        //测试
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserId(1);
        System.out.println(userInfo);
        if (userInfo==null){
            return "login";
        }
        System.out.println(pageNum);
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ArticleInfo> myArtByUserId = articleService.getMyArtByUserId(userInfo);
        System.out.println(myArtByUserId);
        PageInfo<ArticleInfo> articleInfoPageInfo = new PageInfo<ArticleInfo>(myArtByUserId);
        return articleInfoPageInfo;
    }

    /**
     * 通过UserId获取我的草稿(分页)
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping("getMyDraftByUserId")
    public Object getMyDraftByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                           Integer pageNum , HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        //测试
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserId(1);
        System.out.println(userInfo);
        if (userInfo==null){
            return "login";
        }
        System.out.println(pageNum);
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ArticleInfo> myArtByUserId = articleService.getMyDraftByUserId(userInfo);
        System.out.println(myArtByUserId);
        PageInfo<ArticleInfo> articleInfoPageInfo = new PageInfo<ArticleInfo>(myArtByUserId);
        return articleInfoPageInfo;
    }

    /**
     * 通过ArticleId删除我的草稿
     * @param articleId
     * @return
     */
    @RequestMapping("deleteMyDraftByArticleId")
    public Object deleteMyDraftByArticleId(@RequestParam Long articleId){
        if (articleId==0){
            return false;
        }
        return articleService.deleteMyDraftByArticleId(articleId);
    }
}
