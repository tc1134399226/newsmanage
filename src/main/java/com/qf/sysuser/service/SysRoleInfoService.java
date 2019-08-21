package com.qf.sysuser.service;

import com.qf.sysuser.dto.RoleUserInfo;
import com.qf.sysuser.pojo.RoleInfo;
import com.qf.sysuser.vo.RoleInfoVO;

import java.util.List;

public interface SysRoleInfoService {
    public List<RoleInfoVO> listRoleByUserId(Integer id);

    public boolean addRoleAnd(RoleUserInfo roleUserInfo);

    public boolean delRoleAnd(RoleUserInfo roleUserInfo);

    public List<RoleInfo> listAllRoleInfo();
}
