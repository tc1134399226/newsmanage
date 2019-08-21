package com.qf.sysuser.controller;


import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

//    /*
//    @RequestMapping("/loginCheck")
//    @ResponseBody
//    public boolean loginCheck(@RequestBody User user, HttpSession session ){
//        List<MenuInfo> menuInfoList = userService.userLoginInit(user);
//        if (menuInfoList!=null){
//            session.setAttribute("menuInfoList",menuInfoList);
//            session.setAttribute("userinfo",user);
//        }
//        return userService.getUserByuserNameAndPassword(user);
//    }
//
//    @RequestMapping("/registerUser")
//    @ResponseBody
//    public Object saveUser(@RequestBody User user){
//        return userService.registerUser(user);
//    }
//
//    @RequestMapping("/listAllUserInfo")
//    @ResponseBody
//    public Object listAllUserInfo(){
//        List<User> allUser = userService.getAllUser();
//        return allUser;
//    }
//*/

    /**
     * 删除单个用户
     * @param user
     * @return
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestBody User user){
       return sysUserService.deleteUser(user.getUserid());
    }

    /**
     * 删除被选中的用户,有可能多个
     * @param userIdsDTO
     * @return
     */
    @RequestMapping("deleteCheckUser")
    @ResponseBody
    public boolean deleteCheckUser(@RequestBody UserIdsDTO userIdsDTO){
        return sysUserService.deleteUser(userIdsDTO);
    }

    /**
     *  根据用户id 获取用户信息
     * @param user
     * @return
     */
    @RequestMapping("getUserById")
    @ResponseBody
    public User getUserById(@RequestBody User user){
        User userById = sysUserService.getUserById(user);
        return userById;
    }

    /**
     * 根据用户id  更新用户
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody User user){
        boolean flg = sysUserService.updateUser(user);
        return flg;
    }

    /**
     * 根据用户名和账号 进行模糊查询
     * @param user
     * @return
     */
    @RequestMapping("selectData")
    @ResponseBody
    public List<User> selectData(@RequestBody User user){
        return sysUserService.selectData(user);
    }


    /**
     * 添加新的用户
     * @param user
     * @return
     */
    @RequestMapping("insertUser")
    @ResponseBody
    public boolean insertUser(@RequestBody User user){
        return sysUserService.insertUser(user);
    }

//    /**
//     * 初始化用户菜单
//     * @param userInfo
//     * @param session
//     * @return
//     */
//    @RequestMapping("initMenuList")
//    @ResponseBody
//    public Object initMenuList(@RequestBody(required = false) User userInfo,HttpSession session){
//        if(session.getAttribute("menuInfoList")==null){
//            if(userInfo!=null){
//                return userService.userLoginInit(userInfo);
//            }else {
//                return null;
//            }
//        }else{
//            return session.getAttribute("menuInfoList");
//        }
//    }

    /**
     * 管理员登录
     * @param user
     * @return
     */
    @RequestMapping("sysUserLogin")
    @ResponseBody
    public User sysUserLogin(@RequestBody User user){
        return sysUserService.sysUserLogin(user);
    }

}
