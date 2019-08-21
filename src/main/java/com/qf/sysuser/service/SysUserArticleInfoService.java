package com.qf.sysuser.service;



import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.vo.ArticleInfoVO;

import java.util.List;

public interface SysUserArticleInfoService {

    //根据文章id来改变文章的status(通过审核或者不通过)
    public boolean updateArticleStatus(ArticleInfo articleInfo);

    //获取所有待审核的文章信息
    public List<ArticleInfoVO> getAllArticleInfo();

    //根据文章id获取待审核的文章详细信息
    public ArticleInfoVO getArticleInfoById(int id);

    //获取所有已通过审核的文章信息
    public List<ArticleInfoVO> getArticleInfo();

    //根据文章id获取已通过审核的文章详细信息
    public ArticleInfoVO getArticleInfoBy(int id);
}
