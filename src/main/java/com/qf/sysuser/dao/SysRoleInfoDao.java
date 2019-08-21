package com.qf.sysuser.dao;

import com.qf.sysuser.dto.RoleUserInfo;
import com.qf.sysuser.pojo.RoleInfo;
import com.qf.sysuser.vo.RoleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleInfoDao {
    /**
     * 通过用户id获取角色信息
     * @param id
     * @return
     */
    public List<RoleInfoVO> listRoleByUserId(Integer id);

    /**
     * 添加用户 角色 中间表关系
     * @param roleUserInfo
     * @return
     */
    public int addRoleAnd(RoleUserInfo roleUserInfo);

    /**
     * 删除用户 角色 中间表关系
     * @param roleUserInfo
     * @return
     */
    public int delRoleAnd(RoleUserInfo roleUserInfo);

    /**
     * 查询所有角色
     * @return
     */
    public List<RoleInfo> listAllRoleInfo();
}
