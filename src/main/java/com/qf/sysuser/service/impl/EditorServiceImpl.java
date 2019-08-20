package com.qf.sysuser.service.impl;


import com.qf.sysuser.dao.EditorMapper;

import com.qf.sysuser.dto.EditorApplyDTO;
import com.qf.sysuser.pojo.UserInfo;
import com.qf.sysuser.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorServiceImpl implements EditorService {
    @Qualifier("editMapper")
    @Autowired
    EditorMapper editorMapper;

    //将申请成为编辑的个人信息添加(更新)到userInfo表中
    public boolean applyEditor(EditorApplyDTO editorApplyDTO) {
        return this.editorMapper.applyEditor(editorApplyDTO)>0;
    }

    //获取所有申请成为编辑的用户信息
    public List<UserInfo> getAllEditorApply(){
        return this.editorMapper.getAllEditorApply();
    }

    //根据用户id来删除没通过编辑审核的人员信息(数据库中数据不删除)
    public boolean deleteApply(int userId) {
        return this.editorMapper.deleteApply(userId)>0;
    }

    //将通过编辑审核的信息更新到数据库中(改变userInfo表中status来实现)
    public boolean addEditor(int userId) {
        return this.editorMapper.addEditor(userId)>0;
    }

    //通过id来找到申请成为编辑的用户的详细信息
    public UserInfo getEditorApplyById(int userId) {
        return this.editorMapper.getEditorApplyById(userId);
    }


}
