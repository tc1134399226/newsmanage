package com.qf.sysuser.dao;

import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.MenuInfo;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.vo.MenuInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserDao {
    /**
     * 获取所有user
     * @return
     */
    public List<User> getAllUser();

    /**
     * 通过用户名和密码获取用户信息
     * @param user
     * @return
     */
    public User getUserByuserNameAndPassword(User user);

    /**
     * 通过id获取user
     * @param user
     * @return
     */
    public User getUserById(User user);

    /**
     * 保存(注册)用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 通过用户名获取用户信息
     * @param user
     * @return
     */
    public User getUserByuserName(User user);

    /**
     * 通过用户id删除用户
     * @param userid
     * @return
     */
    public int deleteUser(Integer userid);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int updateUser(User user);


    /**
     * 通过用户名或账号进行模糊查询
     */
    public List<User> selectData(User user);

    /**
     * 删除选中用户
     * @param userIdsDTO
     * @return
     */
    public int deleteCheckUser(UserIdsDTO userIdsDTO);

    /**
     * 插入用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 用户登录初始化菜单信息
     * @param user
     * @return
     */
    public List<MenuInfoVO> userLoginInit(User user);



}
