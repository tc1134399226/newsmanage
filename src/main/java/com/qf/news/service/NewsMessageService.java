package com.qf.news.service;

import com.qf.news.pojo.Message;
import com.qf.news.vo.MessageVO;
import com.qf.news.vo.ReplyVO;

import java.util.List;

public interface NewsMessageService {
    /**
     * 通过userId获取已读消息
     * @param userId
     * @return
     */
    public List<MessageVO> getReadMessageByUserId(Long userId);
    /**
     * 彻底删除已读消息
     * @param mgeId
     * @return
     */
    public boolean deleteReadMessageByMgeId(Long mgeId);
    /**
     * 通过userId获取未读消息
     * @param userId
     * @return
     */
    public List<MessageVO> getUnreadMessageByUserId(Long userId);
    /**
     * 将消息从未读消息中删除,加入已读消息中
     * @param mgeId
     * @return
     */
    public boolean removeUnreadMessageByMgeId(Long mgeId);
    /**
     * 把回复添加到消息表内
     * @param replyVO
     * @return
     */
    public boolean sendMessageByReplyVO(ReplyVO replyVO);


    /**
     * 将系统发送的信息添加到信息表中
     * @param message
     * @return
     */
    public boolean sendSystemMessage(Message message);
}
