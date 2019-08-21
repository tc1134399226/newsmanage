package com.qf.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.qf.news.pojo.CommentInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsCommentService;
import com.qf.news.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsCommentController {
    @Autowired
    NewsCommentService newsCommentService;
//    @Autowired
//    UserService userService;

    /**
     * 获取所有的评论
     * @param pageNum
     * @return
     */
    @RequestMapping("allComment")
    public Object allComment(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                         Integer pageNum){
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<CommentVO> commentInfos = newsCommentService.allComment();
        PageInfo<CommentVO> commentInfoPageInfo = new PageInfo<CommentVO>(commentInfos);
        return commentInfoPageInfo;
    }

    /**
     * 添加评论
     * @param commentInfo
     * @param session
     * @return
     */
    @RequestMapping("addComment")
    public Object addComment(@RequestBody CommentInfo commentInfo , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
//       if (user==null){
//           return "login";
//       }
        //保证程序健壮性
        if (user==null){
            return false;
        }
        //获得个人信息
        //添加到CommentInfo对象中
        commentInfo.setUserId(user.getUserId());
        commentInfo.setNickName(user.getNickName());
//        commentInfo.setUserId(3);
//        commentInfo.setNickName("zzg");
        System.out.println(commentInfo);
        if (commentInfo==null){
            return false;
        }
        return newsCommentService.addComment(commentInfo);
    }

    /**
     * 通过ComId删除评论
     * @param commentInfo
     * @param session
     * @return
     */
    @RequestMapping("deleteCommentByComId")
    public Object deleteCommentByComId(@RequestBody CommentInfo commentInfo,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
        if (user==null){
            return "login";
        }
        //保证程序健壮性
        if (user==null){
            return false;
        }
        //获得个人信息
        //判断是不是本人,不是本人不可以删除
        if (user.getUserId()!=commentInfo.getUserId()){
            return false;
//            return "无法删除他人评论";
        }

        long comId = commentInfo.getComId();
        if (comId<0){
            return false;
        }
        System.out.println(commentInfo);

        return newsCommentService.deleteCommentByComId(comId);
    }

}
