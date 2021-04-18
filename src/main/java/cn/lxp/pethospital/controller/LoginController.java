package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.utils.ReturnUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/tologin")
    public String tologin() {
        return "views/user/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ModelMap login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return ReturnUtil.Success("登录成功",token);
        } catch (UnknownAccountException e) {  //用户名不存在
            e.printStackTrace();
            return null;
        } catch (IncorrectCredentialsException e) { //密码不正确
            e.printStackTrace();
            return null;
        }

    }
}
