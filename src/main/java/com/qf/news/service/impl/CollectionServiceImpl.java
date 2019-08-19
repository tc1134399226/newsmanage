package com.qf.news.service.impl;


import com.qf.news.dao.CollectionMapper;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.CollectionService;
import com.qf.news.vo.CollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    /**
     * 通过UserId获取我收藏的文章(分页)
     * @param userInfo
     * @return
     */
    public List<CollectionVO> getCollectionByUserId(UserInfo userInfo) {
        return collectionMapper.getCollectionByUserId(userInfo);
    }

    /**
     * 通过ColId删除我的收藏
     * @param colId
     * @return
     */
    public boolean deleteCollectionByColId(Long colId) {
        return collectionMapper.deleteCollectionByColId(colId)>0;
    }
}
