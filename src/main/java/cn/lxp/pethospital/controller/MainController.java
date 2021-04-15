package cn.lxp.pethospital.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("index")
    public String index(){
        return "views/index";
    }

    @GetMapping("uuid")
    @ResponseBody
    public String getUuid(){
        return IdUtil.simpleUUID();
    }
}
