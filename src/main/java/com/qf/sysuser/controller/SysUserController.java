package com.qf.sysuser.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.sysuser.dto.UserIdsDTO;
import com.qf.sysuser.pojo.MenuInfo;
import com.qf.sysuser.pojo.User;
import com.qf.sysuser.service.SysUserService;
import com.qf.sysuser.vo.MenuInfoVO;
import com.qf.sysuser.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("admin/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



    @RequestMapping("/registerUser")
    @ResponseBody
    public Object saveUser(@RequestBody User user){
        return sysUserService.registerUser(user);
    }

    @RequestMapping("/listAllUserInfo")
    @ResponseBody
    public Object listAllUserInfo(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                              Integer pageNum) {
        System.out.println(pageNum);
        //一页有多少条数据
        int defaultPageSize = 10;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, defaultPageSize);
        List<User> allUser = sysUserService.getAllUser();
        System.out.println(allUser);
        PageInfo<User> allUserPageInfo = new PageInfo<User>(allUser);
        return allUserPageInfo;
    }

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
        System.out.println(user);
        User userById = sysUserService.getUserById(user);
        System.out.println(userById);
        return userById;
    }

    /**
     * 根据用户id  更新用户并且更新session
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody User user,HttpSession session){
        boolean flg = sysUserService.updateUser(user);
        if (flg){
            User userById = sysUserService.getUserById(user);
            session.setAttribute("sysuser",userById);
        }
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

    /**
     * 初始化用户菜单
     * @param userInfo
     * @param session
     * @return
     */
    @RequestMapping("initMenuList")
    public Object initMenuList(@RequestBody(required = false) User userInfo,HttpSession session){
//        MenuInfoVO menuInfos = (MenuInfoVO) session.getAttribute("menuInfoList");
        User sysUser = (User) session.getAttribute("sysUser");
        List<MenuInfoVO> menuInfos = sysUserService.userLoginInit(sysUser);
        System.out.println("session: "+sysUser);
        System.out.println("用户菜单栏: "+menuInfos);
//        if(session.getAttribute("menuInfoList")==null){
        if (menuInfos==null) {
            if (userInfo != null) {
                return sysUserService.userLoginInit(userInfo);
            } else {
                return null;
            }
        }else{
//            return session.getAttribute("menuInfoList");
         return menuInfos;
        }
    }

    /**
     * 管理员登录
     * @param user
     * @return
     */
    @RequestMapping("sysUserLogin")
    @ResponseBody
    public User sysUserLogin(@RequestBody User user, HttpSession session){
        User user1 = sysUserService.sysUserLogin(user);
//        System.out.println(user1);
        if (user1!=null){
            session.setAttribute("sysUser",user1);
            return user1;
        }
        return null;
    }

    @RequestMapping("getSession")
    public Object getSession(HttpSession session){
        Object user = session.getAttribute("sysUser");
        return user;
    }

    @RequestMapping("cleanSession")
    public Object cleanSession(HttpSession session){
        session.removeAttribute("sysUser");
        return true;
    }

    @RequestMapping("listAllMenuInfo")
    @ResponseBody
    public Object listAllMenuInfo(Integer pageNo){
        Integer pageSize=4;//每页显示记录数
        //分页查询
        System.out.println(pageNo);
        PageHelper.startPage(pageNo, pageSize);
        List<MenuInfo> menuList = sysUserService.listAllMenuInfo();;//获取所有用户信息
        PageInfo<MenuInfo> pageInfo=new PageInfo<MenuInfo>(menuList);
        return pageInfo;
    }

    @RequestMapping("listNewsUserInfo")
    public  Object listNewsUserInfo(){
        return sysUserService.listNewsUserInfo();
    }
}
