package com.qf.news.service;


import com.qf.news.pojo.CommentInfo;
import com.qf.news.pojo.LoveComment;
import com.qf.news.vo.CommentVO;

import java.util.List;

public interface NewsCommentService {
    /**
     * 获取所有的评论
     * @return
     */
    public List<CommentVO> allComment(Long articleId);

    /**
     * 添加评论
     * @param commentInfo
     * @return
     */
    public boolean addComment(CommentInfo commentInfo);

    /**
     * 通过ComId删除评论
     * @param comId
     * @return
     */
    public boolean deleteCommentByComId(long comId);
    /**
     * 通过comId获取评论
     * @param comId
     * @return
     */
    public CommentInfo getCommentByComId(long comId);

    /**
     * 点赞(或取消点赞)
     * @param commentInfo
     * @return
     */
    public boolean addLoveComment(CommentInfo commentInfo);
    /**
     * 检测这个用户是否已经点过赞
     * @param commentInfo
     * @return
     */
    public boolean checkLoveComment(CommentInfo commentInfo);
}
