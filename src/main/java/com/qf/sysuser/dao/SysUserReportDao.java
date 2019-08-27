package com.qf.sysuser.dao;

import com.qf.sysuser.vo.ReportVO;

import java.util.List;

public interface SysUserReportDao {

    //查询所有被举报的文章
    List<ReportVO> getAllReport();

}
