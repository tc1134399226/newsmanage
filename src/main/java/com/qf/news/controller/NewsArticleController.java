package com.qf.news.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("news")
public class NewsArticleController {

    @Autowired
    NewsArticleService newsArticleService;

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
        if (userInfo==null){
            return false;
        }
        System.out.println(userInfo);
        System.out.println(pageNum);
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=5;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ArticleInfo> myArtByUserId = newsArticleService.getMyArtByUserId(userInfo);
        System.out.println(myArtByUserId);
        PageInfo<ArticleInfo> articleInfoPageInfo = new PageInfo<ArticleInfo>(myArtByUserId);
        return articleInfoPageInfo;
    }

    /**
     * 通过UserId获取关注小编的文章(分页)
     * @param pageNum
     * @param userInfo
     * @return
     */
    @RequestMapping("getEditorArtByUserId")
    public Object getEditorArtByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
            Integer pageNum , @RequestBody UserInfo userInfo) {
        if (userInfo==null||userInfo.getUserId() == 0) {
            return false;
        }
            System.out.println(pageNum);
            //一页有多少条数据
            int defaultPageSize = 5;
            //初始化pageHelper对象
            PageHelper.startPage(pageNum, defaultPageSize);
            List<ArticleInfo> myArtByUserId = newsArticleService.getMyArtByUserId(userInfo);
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
        public Object getMyDraftByUserId (@RequestParam(required = true, defaultValue = "1", value = "pageNum")
                Integer pageNum, HttpSession session){
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

            if (userInfo == null) {
                return false;
            }
            System.out.println(userInfo);

            System.out.println(pageNum);
            System.out.println(userInfo);
            //一页有多少条数据
            int defaultPageSize = 5;
            //初始化pageHelper对象
            PageHelper.startPage(pageNum, defaultPageSize);
            List<ArticleInfo> myArtByUserId = newsArticleService.getMyDraftByUserId(userInfo);
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
        public Object deleteMyDraftByArticleId (@RequestParam Long articleId){
            if (articleId == 0) {
                return false;
            }
            return newsArticleService.deleteMyDraftByArticleId(articleId);
        }
        @RequestMapping("getcomNumAndLoveNum")
        public Object getcomNumAndLoveNum (@RequestParam Long articleId){
            if (articleId == 0) {
                return false;
            }
            return newsArticleService.getcomNumAndLoveNum(articleId);
        }


}
