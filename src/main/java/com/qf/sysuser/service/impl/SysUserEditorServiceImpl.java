package com.qf.sysuser.service.impl;


import com.qf.sysuser.dao.SysUserEditorMapper;

import com.qf.sysuser.dto.EditorApplyDTO;
import com.qf.sysuser.pojo.UserInfo;
import com.qf.sysuser.service.SysUserEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserEditorServiceImpl implements SysUserEditorService {
    @Autowired
    SysUserEditorMapper sysUserEditorMapper;

    //将申请成为编辑的个人信息添加(更新)到userInfo表中
    public boolean applyEditor(EditorApplyDTO editorApplyDTO) {
        return this.sysUserEditorMapper.applyEditor(editorApplyDTO)>0;
    }

    //获取所有申请成为编辑的用户信息
    public List<UserInfo> getAllEditorApply(){
        return this.sysUserEditorMapper.getAllEditorApply();
    }

    //根据用户id来删除没通过编辑审核的人员信息(数据库中数据不删除)
    public boolean deleteApply(int userId) {
        return this.sysUserEditorMapper.deleteApply(userId)>0;
    }

    //将通过编辑审核的信息更新到数据库中(改变userInfo表中status来实现)
    public boolean addEditor(int userId) {
        return this.sysUserEditorMapper.addEditor(userId)>0;
    }

    //通过id来找到申请成为编辑的用户的详细信息
    public UserInfo getEditorApplyById(int userId) {
        return this.sysUserEditorMapper.getEditorApplyById(userId);
    }

    //获取所有小编的信息
    public List<UserInfo> getAllEditorInfoBySatus() {
        return sysUserEditorMapper.getAllEditorInfoBySatus();
    }

    //根据用户id获取小编的详细信息
    public UserInfo getEditorInfoByUserId(int userId) {
        return sysUserEditorMapper.getEditorInfoByUserId(userId);
    }

    //根据用户id取消小编的编辑资 格
    public boolean cancelEditor(int userId) {
        return sysUserEditorMapper.cancelEditor(userId)>0;
    }

    public List<UserInfo> selectUserInfoByNickNameAnd(UserInfo userInfo) {
        return sysUserEditorMapper.selectUserInfoByNickNameAnd(userInfo);
    }


}
