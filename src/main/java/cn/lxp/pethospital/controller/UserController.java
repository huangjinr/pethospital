package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.UserService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("selectUserList")
    @ResponseBody
    public ModelMap selectUserList(String name,String username,String phone){
        List<User> userList = userService.selectUserList(name,username,phone);
        return ReturnUtil.Success("查询成功",userList);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("insertUser")
    @ResponseBody
    public ModelMap insertUser(User user){
        int count = userService.insertUser(user);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }

    /**
     * 返回编辑用户界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateUserIndex")
    public String selectUserById(String id, Model model){
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "views/user/user/userform";
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    @ResponseBody
    public ModelMap updateUser(User user){
        int count = userService.updateUser(user);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }


    @GetMapping("deleteUserById")
    @ResponseBody
    public ModelMap deleteUserById(String id){
        int count = userService.deleteUserById(id);
        if (count > 0) {
            return ReturnUtil.Success("删除成功");
        } else {
            return ReturnUtil.Error("删除失败");
        }
    }

    /**
     * 返回设置用户我的界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("setUserIndex")
    public String setUserIndex(String id, Model model){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        User user = userService.selectUserById(currentUser.getId());
        model.addAttribute("user",user);
        return "views/set/user/info";
    }

    @RequestMapping("setUser")
    @ResponseBody
    public ModelMap setUser(User user){
        int count = userService.setUser(user);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }

    @RequestMapping("updateUserPassword")
    @ResponseBody
    public ModelMap updateUserPassword(String oldPassword,String password){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        if(!currentUser.getPassword().equals(oldPassword)){
            return ReturnUtil.Error("操作失败");
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPassword(password);
        int count = userService.updateUserPassword(user);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }

}
