package com.qf.sysuser.dao;



import com.qf.sysuser.dto.EditorApplyDTO;
import com.qf.sysuser.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserEditorMapper {

    //将申请成为编辑的个人信息添加(更新)到userInfo表中
    public int applyEditor(EditorApplyDTO editorApplyDTO);

    //获取所有申请成为编辑的用户信息
    public List<UserInfo> getAllEditorApply();

    //根据用户id来删除没通过编辑审核的人员信息(数据库中数据不删除)
    public int deleteApply(int userId);

    //将通过编辑审核的信息更新到数据库中(改变userInfo表中status来实现)
    public int addEditor(int userId);

    //通过id来找到申请成为编辑的用户的详细信息
    public UserInfo getEditorApplyById(int userId);

    //获取所有小编的信息
    public List<UserInfo> getAllEditorInfoBySatus();

    //根据用户id获取小编的详细信息
    public UserInfo getEditorInfoByUserId(int userId);

    //根据用户id取消小编的编辑 资格
    public int cancelEditor(int userId);


    public List<UserInfo> selectUserInfoByNickNameAnd(UserInfo userInfo);

}
