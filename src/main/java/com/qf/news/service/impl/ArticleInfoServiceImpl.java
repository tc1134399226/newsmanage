package com.qf.news.service.impl;

import com.qf.news.dao.NewsArticleInfoMapper;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.LoveArticle;
import com.qf.news.service.NewsArticleInfoService;
import com.qf.news.vo.ArticleTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleInfoServiceImpl implements NewsArticleInfoService {

    @Qualifier("newsArticleInfoMapper")
    @Autowired
    NewsArticleInfoMapper newsArticleInfoMapper;

    //根据articleId查询编辑的新闻显示到预览页面
    public ArticleInfo getReleaseInfoById(int articleId) {
        return newsArticleInfoMapper.getReleaseInfoById(articleId);
    }

    //用户在前台输入新闻添加到数据库
    public boolean commitArticle(ArticleInfo articleInfo) {
        return newsArticleInfoMapper.commitArticle(articleInfo)>0;
    }
    //修改处于编辑未提交审核状态的新闻并确认提交
    public boolean secondCommitArticle(ArticleInfo articleInfo) {
        return newsArticleInfoMapper.secondCommitArticle(articleInfo)>0;
    }

    //根据输入的新闻内容查询获取articleId
    public ArticleInfo getArticleInfoIdById(ArticleInfo articleInfo) {
        try{
            ArticleInfo articleInfoIdById = newsArticleInfoMapper.getArticleInfoIdById(articleInfo);
            return articleInfoIdById;
        }catch (Exception e){
            articleInfo.setArticleId(0);
            articleInfo.setContent("该文章已存在");
            return articleInfo;
        }

    }

    //修改新闻状态
    public boolean updateStatus(int articleId) {
        return newsArticleInfoMapper.updateStatus(articleId)>0;
    }

    public boolean getIP(ArticleInfo articleInfo) {
        return newsArticleInfoMapper.getIP(articleInfo)>0;
    }

    public boolean uploadCover(ArticleInfo articleInfo) {
        return newsArticleInfoMapper.uploadCover(articleInfo)>0;
    }

    /**
     * 获取文章信息和文章热度
     * @param articleId
     * @return
     */
    public ArticleTypeVO getArticleAndLoveNumAndComNum( long articleId){
        return newsArticleInfoMapper.getArticleAndLoveNumAndComNum(articleId);
    }
    /**
     * 用户点赞(取消)
     * @param userId
     * @param articleId
     * @return
     */
    public boolean loveArticle(long userId, long articleId) {
       //判断用户是否点赞过这篇文章
        LoveArticle loveArticleByArticleIdAndUserId = newsArticleInfoMapper.getLoveArticleByArticleIdAndUserId(userId, articleId);
        System.out.println(111);
        System.out.println(loveArticleByArticleIdAndUserId);
        if (loveArticleByArticleIdAndUserId==null){
            System.out.println(222);
           return newsArticleInfoMapper.addLoveArticle(userId, articleId)>0;
        }else {
            System.out.println(333);
            return newsArticleInfoMapper.updateLoveArticle(loveArticleByArticleIdAndUserId)>0;
        }
    }

    @Override
    public boolean uploadArticle(ArticleInfo articleInfo) {
        return newsArticleInfoMapper.uploadArticle(articleInfo)>0;
    }
}
