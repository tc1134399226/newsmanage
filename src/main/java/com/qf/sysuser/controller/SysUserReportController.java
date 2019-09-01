package com.qf.sysuser.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.sysuser.pojo.Message;
import com.qf.sysuser.service.SysUserReportService;
import com.qf.sysuser.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("admin/sysuser")
@RestController
public class SysUserReportController {

    @Autowired
    SysUserReportService sysUserReportService;

    @RequestMapping("getAllReport")
    public  Object getAllReport(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum){
        int pageSize=5;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请的文章信息
        List<ReportVO> allReport = sysUserReportService.getAllReport();
        //将获取的ArticleInfo信息封装到PageInfo中
        PageInfo<ReportVO> report = new PageInfo<ReportVO>(allReport);
        return report;

    }

    @RequestMapping("sendSystemMessage")
    public Object sendSystemMessage(@RequestBody Message message){
//        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");


        message.setSenderId(666);
        message.setMainTitle("您收到一条系统信息");
        System.out.println(message);
       return sysUserReportService.sendSystemMessage(message);
    }

}
