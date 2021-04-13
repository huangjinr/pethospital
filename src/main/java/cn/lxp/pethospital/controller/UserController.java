package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.UserService;
import cn.lxp.pethospital.utils.ReturnUtil;
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
    public ModelMap selectUserList(){

        List<User> userList = userService.selectUserList();
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
}
