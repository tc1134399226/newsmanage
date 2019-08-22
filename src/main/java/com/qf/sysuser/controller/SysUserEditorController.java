package com.qf.sysuser.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.sysuser.dto.EditorApplyDTO;
import com.qf.sysuser.pojo.UserInfo;
import com.qf.sysuser.service.SysUserEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("admin/sysuser")
@RestController
public class SysUserEditorController {
    @Autowired
    SysUserEditorService sysUserEditorService;

    /**
     * 将申请成为编辑的个人信息添加(更新)到userInfo表中
     * @param editorApplyDTO
     * @return
     */
    @RequestMapping("applyEditor")
    public Object applyEditor(@RequestBody EditorApplyDTO editorApplyDTO){
        System.out.println(editorApplyDTO);
        return sysUserEditorService.applyEditor(editorApplyDTO);
    }


    /**
     * 获取所有申请成为编辑的用户信息
     * @return
     */
//    @RequestMapping("admin/getAllEditorApply")
//    public Object getAllEditorApply(){
//        return this.sysUserEditorService.getAllEditorApply();
//    }


    /**
     * 根据用户id来删除没通过编辑审核的人员信息(数据库中数据不删除)
     * @param userId
     * @return
     */
    @RequestMapping("deleteApply")
    public Object deleteApply(@RequestParam int userId){
        return this.sysUserEditorService.deleteApply(userId);
    }


    /**
     * 将通过编辑审核的信息更新到数据库中(改变userInfo表中status来实现)
     * @param userId
     * @return
     */
    @RequestMapping("addEditor")
    public Object addEditor(@RequestParam int userId){
        return this.sysUserEditorService.addEditor(userId);
    }


    /**
     * 通过id来找到申请成为编辑的用户的详细信息
     * @param userId
     * @return
     */
    @RequestMapping("getEditorApplyById")
    public Object getEditorApplyById(@RequestParam int userId){
        return this.sysUserEditorService.getEditorApplyById(userId);
    }


    //分页显示列表
    @RequestMapping("page")
    public Object showlist(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum) {
        int pageSize=4;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请成为编辑的用户信息
        List<UserInfo> allEditorApply = sysUserEditorService.getAllEditorApply();

        //将获取的userInfo信息封装到PageInfo中
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<UserInfo>(allEditorApply);
        return userInfoPageInfo;
    }

}
