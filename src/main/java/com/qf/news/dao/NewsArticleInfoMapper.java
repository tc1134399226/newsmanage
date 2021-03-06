package com.qf.news.dao;


import com.qf.news.dto.ReportDTO;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.LoveArticle;
import com.qf.news.vo.ArticleInfoVO;
import com.qf.news.vo.ArticleTypeVO;
import org.springframework.stereotype.Repository;


@Repository("newsArticleInfoMapper")
public interface NewsArticleInfoMapper {
    //根据articleId查询编辑的新闻显示到预览页面
    public ArticleInfoVO getReleaseInfoById(int releaseId);

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

    /**
     * 插入浏览记录
     * @param articleInfo
     * @return
     */
    public int insertIP(ArticleInfo articleInfo);

    //得到封面图
    public int uploadCover(ArticleInfo articleInfo);

    /**
     * 获取文章信息和文章热度
     * @param articleId
     * @return
     */
    public ArticleTypeVO getArticleAndLoveNumAndComNum( Long articleId,Long userId);
    /**
     * 获取该用户对本文章是否点赞
     * @param userId
     * @param articleId
     * @return
     */
    public LoveArticle getLoveArticleByArticleIdAndUserId(Long userId, Long articleId);

    /**
     * 添加文章点赞记录
     * @param userId
     * @param articleId
     * @return
     */
    public Integer addLoveArticle (Long userId, Long articleId);

    /**
     * 更新文章点赞状态
     * @param loveArticle
     * @return
     */
    public Integer updateLoveArticle (LoveArticle loveArticle);

    /**
     * 通过文章id更新文章
     * @param articleInfo
     * @return
     */
    public int uploadArticle(ArticleInfo articleInfo);

    /**
     * 根据articleId更新文章热度
     * 要和getArticleAndLoveNumAndComNum方法一起调用获取timeHot
     * @param articleTypeVO
     * @return
     */
    public Integer updateTimeHotByArticleId (ArticleTypeVO articleTypeVO);


    /**
     * 举报文章
     * @param reportDTO
     * @return
     */
    public int toReport(ReportDTO reportDTO);
}


