package com.qf.news.service.impl;

import com.qf.news.dao.NewsCommentMapper;
import com.qf.news.dao.NewsMessageMapper;
import com.qf.news.dao.NewsReplyMapper;
import com.qf.news.pojo.CommentInfo;
import com.qf.news.pojo.Message;
import com.qf.news.pojo.ReplyInfo;
import com.qf.news.service.NewsMessageService;
import com.qf.news.vo.MessageVO;
import com.qf.news.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsMessageServiceImpl implements NewsMessageService {

    @Autowired
    NewsMessageMapper newsMessageMapper;
    @Autowired
    NewsCommentMapper newsCommentMapper;
    @Autowired
    NewsReplyMapper newsReplyMapper;
    /**
     * 通过userId获取已读消息
     * @param userId
     * @return
     */
    public List<MessageVO> getReadMessageByUserId(Long userId) {
        return newsMessageMapper.getReadMessageByUserId(userId);
    }

    /**
     * 彻底删除已读消息
     * @param mgeId
     * @return
     */
    public boolean deleteReadMessageByMgeId(Long mgeId) {
        return newsMessageMapper.deleteReadMessageByMgeId(mgeId)>0;
    }

    /**
     * 通过userId获取未读消息
     * @param userId
     * @return
     */
    public List<MessageVO> getUnreadMessageByUserId(Long userId) {
        return newsMessageMapper.getUnreadMessageByUserId(userId);
    }

    /**
     * 将消息从未读消息中删除,加入已读消息中
     * @param mgeId
     * @return
     */
    public boolean removeUnreadMessageByMgeId(Long mgeId) {
        return newsMessageMapper.removeUnreadMessageByMgeId(mgeId)>0;
    }
    /**
     * 把回复添加到消息表内
     * @param replyVO
     * @return
     */
    @Transactional
    public boolean sendMessageByReplyVO(ReplyVO replyVO) {
        //通过被回复消息的id 找到被回复者id
        ReplyInfo replyByRepId = newsReplyMapper.getReplyByRepId(replyVO.getCrepId());
        if (replyByRepId!=null) {
            replyVO.setCuserId(replyByRepId.getUserId());
        }else {
            CommentInfo commentByComId = newsCommentMapper.getCommentByComId(replyVO.getComId());
            replyVO.setCuserId(commentByComId.getUserId());
        }
        System.out.println(replyVO.getCuserId());
        replyVO.setMainTitle("您收到"+replyVO.getNickName()+"发送的消息");
        return newsMessageMapper.sendMessageByReplyVO(replyVO)>0;
    }
    /**
     * 将系统发送的信息添加到信息表中
     * @param message
     * @return
     */
    public boolean sendSystemMessage(Message message) {
        message.setMainTitle("您收到系统消息");
        return newsMessageMapper.sendSystemMessage(message)>0;
    }

    public List<Message> getMessageByUserId(int userId) {
        return this.newsMessageMapper.getMessageByUserId(userId);
    }

}
