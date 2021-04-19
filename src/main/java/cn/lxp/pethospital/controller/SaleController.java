package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Sale;
import cn.lxp.pethospital.service.SaleService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("selectSaleList")
    @ResponseBody
    public ModelMap selectSaleList(String drugName){
        List<Sale> saleList = saleService.selectSaleList(drugName);
        return ReturnUtil.Success("查询成功",saleList);
    }
}
