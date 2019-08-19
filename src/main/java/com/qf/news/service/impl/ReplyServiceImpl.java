package com.qf.news.service.impl;


import com.qf.news.dao.ReplyMapper;
import com.qf.news.pojo.ReplyInfo;
import com.qf.news.service.ReplyService;

import com.qf.news.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    /**
     * 通过ComId获取到这条评论的回复
     * @param comId
     * @return
     */
    public List<ReplyVO> getReplyByComId(long comId) {
        return replyMapper.getReplyByComId(comId);
    }

    /**
     * 添加回复通过repId来指定回复哪一条回复
     * @param replyInfo
     * @return
     */
    public boolean addReplyByReplyInfo(ReplyInfo replyInfo) {
        return replyMapper.addReplyByReplyInfo(replyInfo)>0;
    }

    /**
     * 通过RepId来删除回复
     * @param repId
     * @return
     */
    public boolean deleteReplyByRepId(long repId) {
        return replyMapper.deleteReplyByRepId(repId)>0;
    }
}
