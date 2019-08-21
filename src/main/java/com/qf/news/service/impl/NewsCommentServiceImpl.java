package com.qf.news.service.impl;

import com.qf.news.dao.NewsCommentMapper;
import com.qf.news.pojo.CommentInfo;
import com.qf.news.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    NewsCommentMapper newsCommentMapper;

    /**
     * 获取所有的评论
     * @return
     */
    public List<com.qf.news.vo.CommentVO> allComment() {
        List<com.qf.news.vo.CommentVO> commentVOS = newsCommentMapper.allComment();
        for (com.qf.news.vo.CommentVO c :
                commentVOS ) {
//            try {
//                c.setCreateTime((Timestamp) simpleDateFormat.parse(c.getCreateTime().toString()));
//                System.out.println(c.getCreateTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            System.out.println(c.getCreateTime());
        }


        return commentVOS;
    }

    /**
     * 添加评论
     * @param commentInfo
     * @return
     */
    public boolean addComment(CommentInfo commentInfo) {
       return newsCommentMapper.addComment(commentInfo)>0;

    }
    /**
     * 通过ComId删除评论
     * @param comId
     * @return
     */
    public boolean deleteCommentByComId(long comId) {
        return newsCommentMapper.deleteCommentByComId(comId)>0;
    }
    /**
     * 通过comId获取评论
     * @param comId
     * @return
     */
    public CommentInfo getCommentByComId(long comId) {
        return newsCommentMapper.getCommentByComId(comId);
    }

}
