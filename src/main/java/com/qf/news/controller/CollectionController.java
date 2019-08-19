package com.qf.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.CollectionService;
import com.qf.news.vo.CollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    /**
     * 通过UserId获取我收藏的文章(分页)
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping(value="getCollectionByUserId")
    public Object getCollectionByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                                    Integer pageNum , HttpSession session){
        //,produces = "text/html;charset=UTF-8"
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        //测试
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserId(1);
        if (userInfo==null){
            return "login";
        }
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<CollectionVO> collectionByUserId = collectionService.getCollectionByUserId(userInfo);
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
        return collectionService.deleteCollectionByColId(colId);
    }
}
