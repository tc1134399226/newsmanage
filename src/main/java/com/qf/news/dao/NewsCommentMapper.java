package com.qf.news.dao;


import com.qf.news.pojo.CommentInfo;
import com.qf.news.pojo.LoveComment;
import com.qf.news.vo.CommentVO;

import java.util.List;

public interface NewsCommentMapper {
    /**
     * 获取所有的评论通过文章id
     * @return
     */
    public List<CommentVO> allComment(Long articleId);

    /**
     * 通过参数CommentInfo添加评论
     * @param commentInfo
     * @return
     */
    public Integer addComment(CommentInfo commentInfo);

    /**
     *通过comId删除评论及其回复
     * @param comId
     * @return
     */
    public Integer deleteCommentByComId(long comId);

    /**
     * 通过comId获取评论
     * @param comId
     * @return
     */
    public CommentInfo getCommentByComId(long comId);



    /**
     * 检测这个用户是否已经点过赞
     * @param commentInfo
     * @return
     */
    public LoveComment checkLoveComment(CommentInfo commentInfo);
    /**
     * 检测这个用户是否曾经点击过
     * 即检查是否有这条记录(无论status为0 还是1)
     * @param commentInfo
     * @return
     */
    public LoveComment checkLoveCommentExist(CommentInfo commentInfo);

    /**
     * 添加点赞记录
     * @param commentInfo
     * @return
     */
    public Integer addLoveComment(CommentInfo commentInfo);
    /**
     * 修改点赞记录状态为1
     * @param commentInfo
     * @return
     */
    public Integer addLoveCommentStatus(CommentInfo commentInfo);
    /**
     * 取消点赞(状态置0)
     * @param commentInfo
     * @return
     */
    public Integer deleteLoveComment(CommentInfo commentInfo);

    /**
     * 获取评论点赞数
     * @param comId
     * @return
     */
    public long getNum(long comId);
}
