package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Appointment;
import cn.lxp.pethospital.model.OrderVO;
import cn.lxp.pethospital.service.OrderService;
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

    /**
     * 添加订单
     *
     * @param orderVO
     * @return
     */
    @PostMapping("insertOrder")
    @ResponseBody
    public ModelMap insertOrder(OrderVO orderVO) {
        int count = orderService.insertOrder(orderVO);
        if (count > 0) {
            return ReturnUtil.Success("添加成功");
        } else {
            return ReturnUtil.Error("添加失败");
        }
    }

    /**
     * 返回编辑订单界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateOrderIndex")
    public String selectOrderById(String id, Model model) {
        OrderVO orderVO = orderService.selectOrderById(id);
        model.addAttribute("order", orderVO);
        return "views/order/orderform";
    }

    /**
     * 更新订单信息
     *
     * @param orderVO
     * @return
     */
    @RequestMapping("updateOrder")
    @ResponseBody
    public ModelMap updateOrder(OrderVO orderVO) {
        int count = orderService.updateOrder(orderVO);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }


    /**
     * 根据id删除订单
     *
     * @param id
     * @return
     */
    @GetMapping("deleteOrderByBuyId")
    @ResponseBody
    public ModelMap deleteOrderByBuyId(String id) {
        int count = orderService.deleteOrderByBuyId(id);
        if (count > 0) {
            return ReturnUtil.Success("删除成功");
        } else {
            return ReturnUtil.Error("删除失败");
        }
    }
}
