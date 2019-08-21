package com.qf.news.dao;

import com.qf.news.pojo.UserInfo;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.news.vo.CollectionVO;


import java.util.List;

public interface NewsCollectionMapper {
    /**
     * 通过参数UserInfo中的UserId获取我收藏的文章(分页)
     * @param userInfo
     * @return
     */
    public List<CollectionVO> getCollectionByUserId(UserInfo userInfo);

    /**
     * 通过ColId删除我的收藏
     * @param colId
     * @return
     */
    public Integer deleteCollectionByColId(Long colId);

    /**
     * 通过ArticleId和UserId添加收藏
     * 其中userId是 收藏着userId 不是文章发布者userId
     * @param articleTypeVO
     * @return
     */
    public Integer addCollectByArticleIdAndUserId(ArticleTypeVO articleTypeVO);
}
