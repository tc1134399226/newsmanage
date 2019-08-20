package com.qf.sysuser.dao;



import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.vo.ArticleInfoVO;

import java.util.List;

public interface ArticleInfoMapper {
    //根据文章id来改变文章的status(通过审核或者不通过)
    public int updateArticleStatus(ArticleInfo articleInfo);

    //获取所有文章信息
    public List<ArticleInfoVO> getAllArticleInfo();

    //根据文章id获取详细信息
    public ArticleInfoVO getArticleInfoById(int id);
}
