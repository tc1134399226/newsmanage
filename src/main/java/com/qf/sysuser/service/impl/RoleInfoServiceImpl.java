package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysRoleInfoDao;
import com.qf.sysuser.dto.RoleUserInfo;
import com.qf.sysuser.pojo.RoleInfo;
import com.qf.sysuser.service.SysRoleInfoService;
import com.qf.sysuser.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleInfoServiceImpl implements SysRoleInfoService {
    @Autowired
    private SysRoleInfoDao sysRoleInfoDao;

    /**
     * 通过用户id 获取其所有角色
     * @param id
     * @return
     */
    public List<RoleInfoVO> listRoleByUserId(Integer id) {
         return sysRoleInfoDao.listRoleByUserId(id);
    }

    /**
     * 添加角色和用户关联信息  操作中间表
     * @param roleUserInfo
     * @return
     */
    @Transactional
    public boolean addRoleAnd(RoleUserInfo roleUserInfo){
        int i = sysRoleInfoDao.addRoleAnd(roleUserInfo);
        return i > 0;
    }

    /**
     * 删除角色和用户关联信息  操作中间表
     * @param roleUserInfo
     * @return
     */
    public boolean delRoleAnd(RoleUserInfo roleUserInfo){
        int i = sysRoleInfoDao.delRoleAnd(roleUserInfo);
        return i > 0;
    }

    /**
     * 获取所有的角色信息
     * @return
     */
    public List<RoleInfo> listAllRoleInfo(){
        return sysRoleInfoDao.listAllRoleInfo();
    }
}
