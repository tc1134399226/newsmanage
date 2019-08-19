package com.qf.news.service;

;

import com.qf.news.pojo.UserInfo;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.news.vo.CollectionVO;

import java.util.List;

public interface CollectionService {
  /**
   * 通过UserId获取我收藏的文章(分页)
   * @param userInfo
   * @return
   */
  public List<CollectionVO> getCollectionByUserId(UserInfo userInfo);

  /**
   * 通过ColId删除我的收藏
   * @param colId
   * @return
   */
  public boolean deleteCollectionByColId(Long colId);

  /**
   * 通过ArticleId和UserId添加收藏
   * 其中userId是 收藏着userId 不是文章发布者userId
   * @param articleTypeVO
   * @return
   */
  public boolean addCollectByArticleIdAndUserId(ArticleTypeVO articleTypeVO);
}
