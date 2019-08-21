package com.qf.news.dao;


import com.qf.news.pojo.ArticleInfo;
import org.springframework.stereotype.Repository;


//@Repository("newsArticleInfoMapper")
public interface NewsArticleInfoMapper {
    //根据articleId查询编辑的新闻显示到预览页面
    public ArticleInfo getReleaseInfoById(int releaseId);

    //用户在前台输入新闻添加到数据库
    public int commitArticle(ArticleInfo articleInfo);

    //修改处于编辑未提交审核状态的新闻 并确认提交
    public int secondCommitArticle(ArticleInfo articleInfo);

    //根据输入的新闻内容查询获取articleId
    public ArticleInfo getArticleInfoIdById(ArticleInfo articleInfo);

    //修改新闻状态
    public int updateStatus(int articleId);

    //得到用户IP
    public int getIP(ArticleInfo articleInfo);

    //得到封面图
    public int uploadCover(ArticleInfo articleInfo);
}


