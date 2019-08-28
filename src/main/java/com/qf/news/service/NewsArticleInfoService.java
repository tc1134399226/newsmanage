package com.qf.news.service;


import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.LoveArticle;
import com.qf.news.vo.ArticleInfoVO;
import com.qf.news.vo.ArticleTypeVO;

public interface NewsArticleInfoService {
    //根据articleId查询编辑的新闻显示到预览页面
    public ArticleInfoVO getReleaseInfoById(int articleId);

    //用户在前台输入新闻添加到数据库
    public boolean commitArticle(ArticleInfo articleInfo);

    //修改处于编辑未提交审核状态的新闻
    public boolean secondCommitArticle(ArticleInfo articleInfo);

    /**
     * 根据输入的新闻内容查询获取articleId
     * @param articleInfo
     * @return
     */
    public ArticleInfo getArticleInfoIdById(ArticleInfo articleInfo);

    //修改新闻状态
    public boolean updateStatus(int articleId);

    //得到用户IP
    public boolean getIP(ArticleInfo articleInfo);
    /**
     * 插入浏览记录
     * @param articleInfo
     * @return
     */
    public boolean insertIP(ArticleInfo articleInfo);

    //得到图片的路径
    public boolean uploadCover(ArticleInfo articleInfo);
    /**
     * 获取文章信息和文章热度
     * @param articleId
     * @return
     */
    public ArticleTypeVO getArticleAndLoveNumAndComNum( long articleId);

    /**
     * 用户点赞(取消)
     * @param userId
     * @param articleId
     * @return
     */
    public boolean loveArticle(long userId, long articleId);

    /**
     * 通过id更新新闻
     * @param articleInfo
     * @return
     */
    public boolean uploadArticle(ArticleInfo articleInfo);
}
