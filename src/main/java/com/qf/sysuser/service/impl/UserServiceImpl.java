package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysUserDao;
import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.MenuInfo;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


//    public boolean getUserByuserNameAndPassword(User user) {
//        User user1 = userDao.getUserByuserNameAndPassword(user);
//        if (user1!=null){
//            return true;
//        }else {
//            return false;
//        }
//    }

    public List<User> getAllUser() {
        return sysUserDao.getAllUser();
    }

    public boolean deleteUser(Integer userid) {
        int i = sysUserDao.deleteUser(userid);
        return i > 0;
    }

    public boolean registerUser(User user) {
        if (user.getUsername()==null||"".equals(user.getUsername())||user.getAccount()==null
        ||"".equals(user.getAccount())){
            return false;
        }
        User user1 = sysUserDao.getUserByuserName(user);
        if (user1!=null){
            return false;
        }else {
            int i = sysUserDao.saveUser(user);
            return i > 0;
        }
    }

    public User getUserById(User user) {
        return sysUserDao.getUserById(user);
    }

    public boolean updateUser(User user) {
        int i = sysUserDao.updateUser(user);
        return i > 0;
    }

    @Override
    public List<User> selectData(User user) {
        return sysUserDao.selectData(user);
    }

    public boolean deleteUser(UserIdsDTO userIdsDTO){
        for (Integer userid : userIdsDTO.getUserids()) {
            System.out.println(userid);
        }
        int i = sysUserDao.deleteCheckUser(userIdsDTO);
        return i > 0;
    }
    public boolean insertUser(User user){
        int i = sysUserDao.insertUser(user);
        return i > 0;
    }


    public List<MenuInfo> userLoginInit(User user) {
        return sysUserDao.userLoginInit(user);
    }

}
