package com.qf.news.service;


import com.qf.news.pojo.ReplyInfo;
import com.qf.news.vo.ReplyVO;

import java.util.List;

public interface NewsReplyService {
    /**
     * 通过ComId获取到这条评论的回复
     * @param comId
     * @return
     */
    public List<ReplyVO> getReplyByComId(long comId);

    /**
     * 添加回复通过repId来指定回复哪一条回复
     * @param replyInfo
     * @return
     */
    public boolean addReplyByReplyInfo(ReplyInfo replyInfo);

    /**
     *通过RepId来删除回复
     * @param repId
     * @return
     */
    public boolean deleteReplyByRepId(long repId);
}
