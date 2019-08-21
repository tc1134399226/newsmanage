package com.qf.sysuser.service;


import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.MenuInfo;
import com.qf.sysuser.pojo.User;

import java.util.List;

public interface SysUserService {
    public List<User> getAllUser();
//    public boolean registerUser(User user);
//    public boolean getUserByuserNameAndPassword(User user);
    public User getUserById(User user);
    public boolean deleteUser(Integer userid);
    public boolean updateUser(User user);
    public List<User> selectData(User user);
    public boolean deleteUser(UserIdsDTO userIdsDTO);
    public boolean insertUser(User user);

//    public List<MenuInfo> userLoginInit(User user);
}
