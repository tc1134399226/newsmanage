package com.qf.news.dao;


import com.qf.news.pojo.CommentInfo;
import com.qf.news.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    /**
     * 获取所有的评论
     * @return
     */
    public List<CommentVO> allComment();

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

}
