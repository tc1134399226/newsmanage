package com.qf.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.news.pojo.Message;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsMessageService;
import com.qf.news.vo.MessageVO;
import com.qf.news.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsMessageController {
    @Autowired
    NewsMessageService newsMessageService;

    /**
     * 通过userId获取已读消息
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping("getReadMessageByUserId")
    public Object getReadMessageByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                                     Integer pageNum , HttpSession session){
//        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        if (userInfo.getUserId()==0){
            return "login";
        }
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<MessageVO> readMessageByUserId = newsMessageService.getReadMessageByUserId(userInfo.getUserId());
        PageInfo<MessageVO> messagePageInfo = new PageInfo<MessageVO>(readMessageByUserId);
        return messagePageInfo;
    }

    /**
     * 彻底删除已读消息
     * @param mgeId
     * @return
     */
    @RequestMapping("deleteReadMessageByMgeId")
public Object deleteReadMessageByMgeId(@RequestParam Long mgeId){
        if (mgeId==0){
            return false;
        }
        return newsMessageService.deleteReadMessageByMgeId(mgeId);
}

    /**
     * 通过userId获取未读消息
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping("getUnreadMessageByUserId")
    public Object getUnreadMessageByUserId(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                                 Integer pageNum , HttpSession session){
//        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        if (userInfo.getUserId()==0){
            return "login";
        }
        System.out.println(userInfo);
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<MessageVO> readMessageByUserId = newsMessageService.getUnreadMessageByUserId(userInfo.getUserId());
        PageInfo<MessageVO> messagePageInfo = new PageInfo<MessageVO>(readMessageByUserId);
        return messagePageInfo;
    }

    /**
     * 将消息从未读消息中删除,加入已读消息中
     * @param mgeId
     * @return
     */
    @RequestMapping("removeUnreadMessageByMgeId")
    public Object removeUnreadMessageByMgeId(@RequestParam Long mgeId){
        if (mgeId==0){
            return false;
        }
        return newsMessageService.removeUnreadMessageByMgeId(mgeId);
    }

    /**
     * 用户回复消息给被回复者发送信息和内容
     * @param replyVO
     * @param session
     * @return
     */
    @RequestMapping("sendMessageByReplyVO")
    public Object sendMessageByReplyVO(@RequestBody ReplyVO replyVO,HttpSession session){
//        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        userInfo.setNickName("cg");
      if (userInfo==null){
          return "login";
      }
        if (replyVO==null){
            return false;
        }
        replyVO.setUserId(userInfo.getUserId());
        replyVO.setNickName(userInfo.getNickName());
        System.out.println(replyVO);
        return newsMessageService.sendMessageByReplyVO(replyVO);
    }

    @RequestMapping("sendSystemMessage")
    public Object sendSystemMessage(@RequestBody Message message,HttpSession session){
//        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        if (userInfo==null){
            return "login";
        }
        if (message==null){
            return false;
        }
        message.setUserId(userInfo.getUserId());
        message.setSenderId(666);
        return newsMessageService.sendSystemMessage(message);
    }

    @RequestMapping("getMessageByUserId")
    public Object getMessageByUserId(@RequestParam int userId){
        return newsMessageService.getMessageByUserId(userId);
    }


}
