package com.qf.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsCollectionService;
import com.qf.news.vo.ArticleTypeVO;
import com.qf.news.vo.CollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsCollectionController {

    @Autowired
    NewsCollectionService newsCollectionService;

    /**
     * 通过UserId获取我收藏的文章(分页)
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping(value="getCollectionByUserId")
    public Object getCollectionByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                                    Integer pageNum , HttpSession session) throws IOException {
        //,produces = "text/html;charset=UTF-8"
      UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

//        System.out.println(userInfo);
        //测试
//        UserInfo userInfo=new UserInfo();
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<CollectionVO> collectionByUserId = newsCollectionService.getCollectionByUserId(userInfo);
        PageInfo<CollectionVO> collectionVOPageInfo = new PageInfo<CollectionVO>(collectionByUserId);
        return collectionVOPageInfo;
    }

    /**
     * 通过ColId删除我的收藏
     * @param colId
     * @return
     */
    @RequestMapping("deleteCollectionByColId")
    public boolean deleteCollectionByColId(@RequestParam Long colId){
        if (colId==0){
            return false;
        }
        return newsCollectionService.deleteCollectionByColId(colId);
    }

    /**
     * 通过ArticleId和UserId添加收藏
     * 其中userId是 收藏着userId 不是文章发布者userId
     * @param articleTypeVO
     * @return
     */
    @RequestMapping("addCollectByArticleIdAndUserId")
    public boolean addCollectByArticleIdAndUserId(@RequestBody ArticleTypeVO articleTypeVO){

        if (articleTypeVO==null){
            return false;
        }
        return newsCollectionService.addCollectByArticleIdAndUserId(articleTypeVO);
    }
}
