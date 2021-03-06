package com.qf.sysuser.service.impl;



import com.qf.sysuser.dao.SysUserArticleInfoMapper;
import com.qf.sysuser.pojo.ArticleInfo;
import com.qf.sysuser.service.SysUserArticleInfoService;
import com.qf.sysuser.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserArticleInfoServiceImpl implements SysUserArticleInfoService {
    @Autowired
    SysUserArticleInfoMapper sysUserArticleInfoMapper;

    //根据文章id来改变文章的status(通过审核或者不通过)
    public boolean updateArticleStatus(ArticleInfo articleInfo) {
        return this.sysUserArticleInfoMapper.updateArticleStatus(articleInfo)>0;
    }

    //获取所有文章信息
    public List<ArticleInfoVO> getAllArticleInfo() {
        return this.sysUserArticleInfoMapper.getAllArticleInfo();
    }

    //根据文章id获取详细信息
    public ArticleInfoVO getArticleInfoById(int id) {
        return this.sysUserArticleInfoMapper.getArticleInfoById(id);
    }

    //获取所有已通过审核的文章信息
    public List<ArticleInfoVO> getArticleInfo(ArticleInfo articleInfo) {
        return this.sysUserArticleInfoMapper.getArticleInfo(articleInfo);
    }

    //根据文章id获取已通过审核的文章详细信息
    public ArticleInfoVO getArticleInfoBy(int id) {
        return this.sysUserArticleInfoMapper.getArticleInfoBy(id);
    }


}
