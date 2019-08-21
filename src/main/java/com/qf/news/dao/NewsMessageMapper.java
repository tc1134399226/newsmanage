package com.qf.news.dao;

import com.qf.news.pojo.Message;
import com.qf.news.vo.MessageVO;
import com.qf.news.vo.ReplyVO;

import java.util.List;

public interface NewsMessageMapper {
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
    public Integer deleteReadMessageByMgeId(Long mgeId);
    
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
    public Integer removeUnreadMessageByMgeId(Long mgeId);

    /**
     * 把回复添加到消息表内
     * @param replyVO
     * @return
     */
     public Integer sendMessageByReplyVO(ReplyVO replyVO);

     public Integer sendSystemMessage(Message message);
}
