package com.qf.sysuser.service.impl;

import com.qf.sysuser.dao.SysUserDao;
import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.service.SysUserService;
import com.qf.sysuser.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;


//    public boolean getUserByuserNameAndPassword(User user) {
//        User user1 = userDao.getUserByuserNameAndPassword(user);
//        if (user1!=null){
//            return true;
//        }else {
//            return false;
//        }
//    }

    /**
     * 获取所有用户信息 操作中间表
     * @return
     */
    public List<User> getAllUser() {
        return sysUserDao.getAllUser();
    }

    /**
     * 删除用户信息 操作中间表
     * @param userid
     * @return
     */
    public boolean deleteUser(Integer userid) {
        int i = sysUserDao.deleteUser(userid);
        return i > 0;
    }

//    public boolean registerUser(User user) {
//        if (user.getUsername()==null||"".equals(user.getUsername())||user.getAccount()==null
//        ||"".equals(user.getAccount())){
//            return false;
//        }
//        User user1 = sysUserDao.getUserByuserName(user);
//        if (user1!=null){
//            return false;
//        }else {
//            int i = sysUserDao.saveUser(user);
//            return i > 0;
//        }
//    }

    /**
     * 通过用户id获取用户信息
    * @param user
     * @return
     */
    public User getUserById(User user) {
        return sysUserDao.getUserById(user);
    }

    /**
     * 更新后台用户信息 通过id
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        int i = sysUserDao.updateUser(user);
        return i > 0;
    }

    /**
     * 通过账号或用户名模糊查询用户的信息
     * @param user
     * @return
     */
    public List<User> selectData(User user) {
        return sysUserDao.selectData(user);
    }

    /**
     * 删除(更改状态)用户
     * @param userIdsDTO
     * @return
     */
    public boolean deleteUser(UserIdsDTO userIdsDTO){
        for (Integer userid : userIdsDTO.getUserids()) {
            System.out.println(userid);
        }
        int i = sysUserDao.deleteCheckUser(userIdsDTO);
        return i > 0;
    }

    /**
     * 新增后台用户
     * @param user
     * @return
     */
    public boolean insertUser(User user){
        int i = sysUserDao.insertUser(user);
        return i > 0;
    }

    //管理员登录
    public User sysUserLogin(User user) {
        return sysUserDao.sysUserLogin(user);
    }




    /**
     *  初始化用户菜单
     * @param user
     * @return
     */
    public List<MenuInfoVO> userLoginInit(User user) {
        return sysUserDao.userLoginInit(user);
    }

}
