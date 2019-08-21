package com.qf.sysuser.service;


import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.MenuInfo;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.vo.MenuInfoVO;

import java.util.List;

public interface SysUserService {
    //获取所有后台用户信息
    public List<User> getAllUser();
//    public boolean registerUser(User user);
//    public boolean getUserByuserNameAndPassword(User user);
    public User getUserById(User user);
    //通过id删除用过
    public boolean deleteUser(Integer userid);
    // 更新 用户
    public boolean updateUser(User user);
    //通过账号或用户名模糊查询
    public List<User> selectData(User user);
    //删除(更改status)用户
    public boolean deleteUser(UserIdsDTO userIdsDTO);
    //插入用户信息
    public boolean insertUser(User user);

    //初始化用户菜单
    public List<MenuInfoVO> userLoginInit(User user);
}