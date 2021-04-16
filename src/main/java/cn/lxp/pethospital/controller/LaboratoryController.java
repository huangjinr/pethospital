package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Drug;
import cn.lxp.pethospital.model.Laboratory;
import cn.lxp.pethospital.service.LaboratoryService;
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
@RequestMapping("laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    /**
     * 查询化验信息列表
     * @return
     */
    @GetMapping("selectLaboratoryList")
    @ResponseBody
    public ModelMap selectLaboratoryList(){
        List<Laboratory> laboratoryList = laboratoryService.selectLaboratoryList();
        return ReturnUtil.Success("查询成功",laboratoryList);
    }

    /**
     * 添加化验
     *
     * @param laboratory
     * @return
     */
    @PostMapping("insertLaboratory")
    @ResponseBody
    public ModelMap insertLaboratory(Laboratory laboratory) {
        int count = laboratoryService.insertLaboratory(laboratory);
        if (count > 0) {
            return ReturnUtil.Success("添加成功");
        } else {
            return ReturnUtil.Error("添加失败");
        }
    }

    /**
     * 返回编辑化验界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateLaboratoryIndex")
    public String selectLaboratoryById(String id, Model model) {
        Laboratory laboratory = laboratoryService.selectLaboratoryById(id);
        model.addAttribute("laboratory", laboratory);
        return "views/laboratory/laboratoryform";
    }

    /**
     * 更新化验信息
     *
     * @param laboratory
     * @return
     */
    @RequestMapping("updateLaboratory")
    @ResponseBody
    public ModelMap updateLaboratory(Laboratory laboratory) {
        int count = laboratoryService.updateLaboratory(laboratory);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }


    /**
     * 根据id删除化验
     *
     * @param id
     * @return
     */
    @GetMapping("deleteLaboratoryById")
    @ResponseBody
    public ModelMap deleteLaboratoryById(String id) {
        int count = laboratoryService.deleteLaboratoryById(id);
        if (count > 0) {
            return ReturnUtil.Success("删除成功");
        } else {
            return ReturnUtil.Error("删除失败");
        }
    }
}
