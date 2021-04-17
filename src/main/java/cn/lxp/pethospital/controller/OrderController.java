package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Appointment;
import cn.lxp.pethospital.model.OrderVO;
import cn.lxp.pethospital.service.OrderService;
import cn.lxp.pethospital.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单信息列表
     * @return
     */
    @GetMapping("selectOrderList")
    @ResponseBody
    public ModelMap selectOrderList(){
        List<OrderVO> orderVOList = orderService.selectOrderList();
        return ReturnUtil.Success("查询成功",orderVOList);
    }
}
