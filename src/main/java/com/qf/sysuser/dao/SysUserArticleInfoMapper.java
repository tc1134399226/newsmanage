package com.qf.sysuser.dao;



import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.vo.ArticleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserArticleInfoMapper {
    //根据文章id来改变文章的status(通过审核或者不通过)
    public int updateArticleStatus(ArticleInfo articleInfo);

    //获取所有待审核文章信息
    public List<ArticleInfoVO> getAllArticleInfo();

    //根据文章id获取待审核文章的详细信息
    public ArticleInfoVO getArticleInfoById(int id);

    //(根据条件)获取所有已通过审核的文章信息
    public List<ArticleInfoVO> getArticleInfo(ArticleInfo articleInfo);

    //根据文章id获取已通过审核的文章详细信息
    public ArticleInfoVO getArticleInfoBy(int id);

}
