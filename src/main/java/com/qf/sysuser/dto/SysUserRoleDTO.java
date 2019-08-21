package com.qf.sysuser.dto;

import lombok.Data;

@Data
public class SysUserRoleDTO {

    Integer sysId;
    Integer roleId;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRoleDTO{" +
                "sysId=" + sysId +
                ", roleId=" + roleId +
                '}';
    }
}
