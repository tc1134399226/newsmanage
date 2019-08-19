package com.qf.news.service.impl;

import com.qf.news.dao.CommentMapper;
import com.qf.news.pojo.CommentInfo;
import com.qf.news.service.CommentService;
import com.qf.news.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 获取所有的评论
     * @return
     */
    public List<com.qf.news.vo.CommentVO> allComment() {
        List<com.qf.news.vo.CommentVO> commentVOS = commentMapper.allComment();
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
       return commentMapper.addComment(commentInfo)>0;

    }

    /**
     * 通过ComId删除评论
     * @param comId
     * @return
     */
    public boolean deleteCommentByComId(long comId) {
        return commentMapper.deleteCommentByComId(comId)>0;
    }

    private class CommentVO {
    }
}
