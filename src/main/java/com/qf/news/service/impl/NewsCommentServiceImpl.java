package com.qf.news.service.impl;

import com.qf.news.dao.NewsCommentMapper;
import com.qf.news.pojo.CommentInfo;
import com.qf.news.pojo.LoveComment;
import com.qf.news.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    NewsCommentMapper newsCommentMapper;

    /**
     * 获取所有的评论
     * @return
     */
    public List<com.qf.news.vo.CommentVO> allComment(Long articleId) {

        List<com.qf.news.vo.CommentVO> commentVOS = newsCommentMapper.allComment(articleId);
        for (com.qf.news.vo.CommentVO c :
                commentVOS ) {
            long num = newsCommentMapper.getNum(c.getComId());
            c.setComLoveNum(num);
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

    /**
     * 点赞或取消点赞
     * @param commentInfo
     * @return
     */
    @Transactional
    public boolean addLoveComment(CommentInfo commentInfo) {
        //验真数据库中是否有这条点赞记录
        LoveComment loveComment = newsCommentMapper.checkLoveCommentExist(commentInfo);
        if (loveComment==null){
            System.out.println(1);
            //数据库中无这条点赞记录就执行插入
            return newsCommentMapper.addLoveComment(commentInfo)>0;
        }else {
            System.out.println(2);
            LoveComment loveCommentStatus = newsCommentMapper.checkLoveComment(commentInfo);
            if (loveCommentStatus==null){
                System.out.println(3);
                return newsCommentMapper.addLoveCommentStatus(commentInfo)>0;
            }else{
                System.out.println(4);
                //数据库中有这条点赞记录就取消点赞
                return newsCommentMapper.deleteLoveComment(commentInfo)>0;
            }
        }
    }
    /**
     * 检测这个用户是否已经点过赞
     * @param commentInfo
     * @return
     */
    public boolean checkLoveComment(CommentInfo commentInfo) {
        LoveComment loveComment = newsCommentMapper.checkLoveComment(commentInfo);
        if (loveComment==null){
            return false;
        }else {
            return true;
        }
    }


}
