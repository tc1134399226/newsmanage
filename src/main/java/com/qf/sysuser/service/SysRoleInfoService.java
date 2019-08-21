package com.qf.sysuser.service;

import com.qf.sysuser.dto.RoleUserInfo;
import com.qf.sysuser.pojo.RoleInfo;
import com.qf.sysuser.vo.RoleInfoVO;

import java.util.List;

public interface SysRoleInfoService {
    //通过用户id获取用户所有角色信息
    public List<RoleInfoVO> listRoleByUserId(Integer id);

    //添加用户和角色的关系  操作中间表
    public boolean addRoleAnd(RoleUserInfo roleUserInfo);

    //删除用户和角色的关系  操作中间表
    public boolean delRoleAnd(RoleUserInfo roleUserInfo);

    //获取所有的角色信息
    public List<RoleInfo> listAllRoleInfo();
}
