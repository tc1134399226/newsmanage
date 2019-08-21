package com.qf.news.service;


import com.qf.news.pojo.CommentInfo;
import com.qf.news.vo.CommentVO;

import java.util.List;

public interface NewsCommentService {
    /**
     * 获取所有的评论
     * @return
     */
    public List<CommentVO> allComment();

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
}
