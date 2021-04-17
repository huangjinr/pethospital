package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Income;
import cn.lxp.pethospital.service.IncomeService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @RequestMapping("selectIncomeList")
    @ResponseBody
    public ModelMap selectIncomeList(){
        List<Income> incomeList = incomeService.selectIncomeList();
        return ReturnUtil.Success("查询成功",incomeList);
    }
}
