package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysUserReportMapper;
import com.qf.sysuser.service.SysUserReportService;
import com.qf.sysuser.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserReportServiceImpl implements SysUserReportService {

    @Autowired
    SysUserReportMapper sysUserReportMapper;

    //查询所有被举报的文章
    public List<ReportVO> getAllReport() {
        return sysUserReportMapper.getAllReport();
    }
}
