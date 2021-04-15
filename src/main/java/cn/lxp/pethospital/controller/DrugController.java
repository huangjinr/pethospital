package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Drug;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.DrugService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    /**
     * 查询药品信息列表
     * @return
     */
    @GetMapping("selectDrugList")
    @ResponseBody
    public ModelMap selectDrugList(){
        List<Drug> drugList = drugService.selectDrugList();
        return ReturnUtil.Success("查询成功",drugList);
    }

}
