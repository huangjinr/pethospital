package cn.lxp.pethospital.controller;

import cn.lxp.pethospital.model.Appointment;
import cn.lxp.pethospital.model.Laboratory;
import cn.lxp.pethospital.service.AppointmentService;
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
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /**
     * 查询预约信息列表
     * @return
     */
    @GetMapping("selectAppointmentList")
    @ResponseBody
    public ModelMap selectLaboratoryList(String name,Integer isSuccessful){
        List<Appointment> appointmentList = appointmentService.selectAppointmentList(name,isSuccessful);
        return ReturnUtil.Success("查询成功",appointmentList);
    }

    /**
     * 添加预约
     *
     * @param appointment
     * @return
     */
    @PostMapping("insertAppointment")
    @ResponseBody
    public ModelMap insertAppointment(Appointment appointment) {
        int count = appointmentService.insertAppointment(appointment);
        if (count > 0) {
            return ReturnUtil.Success("添加成功");
        } else {
            return ReturnUtil.Error("添加失败");
        }
    }

    /**
     * 返回编辑预约界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateAppointmentIndex")
    public String selectAppointmentById(String id, Model model) {
        Appointment appointment = appointmentService.selectAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "views/appointment/appointmentform";
    }


    /**
     * 更新预约信息
     *
     * @param appointment
     * @return
     */
    @RequestMapping("updateAppointment")
    @ResponseBody
    public ModelMap updateAppointment(Appointment appointment) {
        int count = appointmentService.updateAppointment(appointment);
        if (count > 0) {
            return ReturnUtil.Success("修改成功");
        } else {
            return ReturnUtil.Error("操作失败");
        }
    }

    /**
     * 根据id删除预约
     *
     * @param id
     * @return
     */
    @GetMapping("deleteAppointmentById")
    @ResponseBody
    public ModelMap deleteAppointmentById(String id) {
        int count = appointmentService.deleteAppointmentById(id);
        if (count > 0) {
            return ReturnUtil.Success("删除成功");
        } else {
            return ReturnUtil.Error("删除失败");
        }
    }
}
