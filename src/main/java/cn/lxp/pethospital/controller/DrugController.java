package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Drug;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.DrugService;
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


    /**
     * 添加药品信息
     * @param drug
     * @return
     */
    @PostMapping("insertDrug")
    @ResponseBody
    public ModelMap insertDrug(Drug drug){
        int count = drugService.insertDrug(drug);
        if (count > 0) {
            return ReturnUtil.Success("添加成功");
        } else {
            return ReturnUtil.Error("添加失败");
        }
    }

    /**
     * 返回编辑药品信息页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("updateDrugIndex")
    public String selectDrugById(String id, Model model){
        Drug drug = drugService.selectDrugById(id);
        model.addAttribute("drug",drug);
        return "views/drug/drugform";
    }


    /**
     * 更新药品信息
     * @param drug
     * @return
     */
    @PostMapping("updateDrug")
    @ResponseBody
    public ModelMap updateDrug(Drug drug){
        int count = drugService.updateDrug(drug);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("修改失败");
        }
    }

    @GetMapping("deleteDrugById")
    @ResponseBody
    public ModelMap deleteDrugById(String id){
        int count = drugService.deleteDrugById(id);
        if (count > 0) {
            return ReturnUtil.Success("删除成功");
        } else {
            return ReturnUtil.Error("删除失败");
        }
    }
}
