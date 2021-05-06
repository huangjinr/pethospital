package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.RegisterService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("insertUser")
    @ResponseBody
    public ModelMap regist(User user){
        Integer result = registerService.insertUser(user);
        if (result > 0) {
            return ReturnUtil.Success("注册成功");
        } else {
            return ReturnUtil.Error("添加失败");
        }
    }
}
