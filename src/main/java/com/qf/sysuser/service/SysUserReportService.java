package com.qf.sysuser.service;

import com.qf.sysuser.pojo.Message;
import com.qf.sysuser.vo.ReportVO;

import java.util.List;

public interface SysUserReportService {

    //查询所有被举报的文章
    List<ReportVO> getAllReport();

    //系统反馈信息加入数据库
    boolean sendSystemMessage(Message message);
}
