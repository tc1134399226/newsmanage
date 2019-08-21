package com.qf.sysuser.controller;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserArticleInfoService;
import com.qf.sysuser.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("admin/sysuser")
@RestController
public class SysUserArticleInfoController {
    @Autowired
    SysUserArticleInfoService sysUserArticleInfoService;

    /**
     *根据文章id来改变文章的status(通过审核或者不通过)
     * @param articleInfo
     * @return
     */
    @RequestMapping("updateArticleStatus")
    public Object updateArticleStatus(@RequestBody ArticleInfo articleInfo){
        return this.sysUserArticleInfoService.updateArticleStatus(articleInfo);

    }

    /**
     * 获取所有需要审核的文章信息
     * @return
     */
    @RequestMapping("getAllArticleInfo")
    public Object getAllArticleInfo(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum){
        int pageSize=2;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请的文章信息
        List<ArticleInfoVO> allArticleInfoVO = sysUserArticleInfoService.getAllArticleInfo();
        //将获取的ArticleInfo信息封装到PageInfo中
        PageInfo<ArticleInfoVO> ArticleInfoPageInfo = new PageInfo<ArticleInfoVO>(allArticleInfoVO);
        return ArticleInfoPageInfo;
    };

    /**
     * 根据文章id获取需要审核的文章详细信息
     * @param articleId
     * @return
     */
    @RequestMapping("getArticleInfoById")
    public Object getArticleInfoById(@RequestParam int articleId){
        return sysUserArticleInfoService.getArticleInfoById(articleId);
    }


    /**
     * 获取所有已通过审核的文章信息
     * @return
     */
    @RequestMapping("getArticleInfo")
    public Object getArticleInfo(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum){
        int pageSize=2;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请的文章信息
        List<ArticleInfoVO> allArticleInfoVO = sysUserArticleInfoService.getArticleInfo();
        //将获取的ArticleInfo信息封装到PageInfo中
        PageInfo<ArticleInfoVO> ArticleInfoPageInfo = new PageInfo<ArticleInfoVO>(allArticleInfoVO);
        return ArticleInfoPageInfo;
    };

    /**
     * 根据文章id获取已通过审核的文章详细信息
     * @param articleId
     * @return
     */
    @RequestMapping("getArticleInfoBy")
    public Object getArticleInfoBy(@RequestParam int articleId){
        return sysUserArticleInfoService.getArticleInfoBy(articleId);
    }
}
