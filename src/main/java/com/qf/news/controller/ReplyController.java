package com.qf.news.controller;

import com.qf.news.pojo.ReplyInfo;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.ReplyService;
import com.qf.news.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    ReplyService replyService;
//    @Autowired
//    UserService userService;

    /**
     * 通过ComId获取到这条评论的回复
     * @param replyVO
     * @return
     */
    @RequestMapping("getReplyByComId")
    public Object getReplyByComId(@RequestBody ReplyVO replyVO){

        List<ReplyVO> replyByComId = replyService.getReplyByComId(replyVO.getComId());
        System.out.println(replyByComId);
        return replyByComId;
    }

    /**
     * 添加回复通过repId来指定回复哪一条回复
     * @param replyInfo
     * @param session
     * @return
     */
    @RequestMapping("addReplyByReplyInfo")
    public Object addReplyByReplyInfo(@RequestBody ReplyInfo replyInfo , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
        if (user==null){
            return "login";
        }
        //保证程序健壮性
//        UserInfo userInfo = userService.checkName(user);
//        if (userInfo==null){
//            return false;
//        }
//        replyInfo.setUserId(3);
//        replyInfo.setNickName("zzg");
////        replyInfo.setUserId(user.getUserId());
////        replyInfo.setNickName(user.getNickName());
        //获得个人信息
       //添加到ReplyInfo对象中
       if (replyInfo==null){
           return  false;
       }
        return replyService.addReplyByReplyInfo(replyInfo);
    }

    /**
     * 通过RepId来删除回复
     * @param replyInfo
     * @param session
     * @return
     */
    @RequestMapping("deleteReplyByRepId")
    public Object deleteReplyByRepId(@RequestBody ReplyInfo replyInfo, HttpSession session){
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
        if (user.getUserId()!=replyInfo.getUserId()){
            return false;
//            return "无法删除他人评论";
        }
        System.out.println(replyInfo.getUserId());

        long repId = replyInfo.getRepId();
        System.out.println(repId);
        if (repId<=0){
            return  false;
        }
        return replyService.deleteReplyByRepId(repId);
    }
}
