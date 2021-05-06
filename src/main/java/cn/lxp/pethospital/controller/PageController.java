package cn.lxp.pethospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("appointmentList")
    public String appointmentList(){
        return "/views/appointment/appointment-list";
    }

    @GetMapping("orderList")
    public String orderList(){
        return "/views/order/order-list";
    }

    @GetMapping("laboratoryList")
    public String laboratoryList(){
        return "/views/laboratory/laboratory-list";
    }
}
