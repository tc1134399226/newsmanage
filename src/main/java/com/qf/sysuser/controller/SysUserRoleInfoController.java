package com.qf.sysuser.controller;

import com.qf.sysuser.dto.RoleUserInfo;
import com.qf.sysuser.service.SysRoleInfoService;
import com.qf.sysuser.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin/roleinfo")
public class SysUserRoleInfoController {

    @Autowired
    private SysRoleInfoService sysRoleInfoService;

    /**
     * 通过用户id获取角色信息
     * @param userid
     * @return
     */
    @RequestMapping("getRoleInfoById")
    @ResponseBody
    public List<RoleInfoVO> getRoleInfoById(Integer userid){
        return sysRoleInfoService.listRoleByUserId(userid);
    }

    /**
     * 添加角色信息
     * @param roleUserInfo
     * @return
     */
    @RequestMapping("addRoleUser")
    @ResponseBody
    public boolean addRoleUser(@RequestBody RoleUserInfo roleUserInfo){
        return sysRoleInfoService.addRoleAnd(roleUserInfo);
    }

    /**
     * 通过id删除角色信息
     * @param roleUserInfo
     * @return
     */
    @RequestMapping("delRoleUser")
    @ResponseBody
    public boolean delRoleUser(@RequestBody RoleUserInfo roleUserInfo){
        return sysRoleInfoService.delRoleAnd(roleUserInfo);
    }

    /**
     * 获取全部角色信息
     * @return
     */
    @RequestMapping("/listAllRoleInfo")
    @ResponseBody
    public Object listAllUserInfo(){
        return sysRoleInfoService.listAllRoleInfo();
    }
}
