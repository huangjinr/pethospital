package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.AppointmentMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.model.Appointment;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.AppointmentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Appointment> selectAppointmentList(String name,Integer isSuccessful) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();

        Map<String, Object> map = new HashMap<>();
        if(currentUser.getRole().getRoleType() == 2){
            String userId = currentUser.getId();
            map.put("userId",userId);
        }
        if (name != null && !"".equals(name)){
            map.put("name",name);
        }
        if (name != null){
            map.put("isSuccessful",isSuccessful);
        }
        return appointmentMapper.selectAppointmentList(map);
    }

    @Override
    public int insertAppointment(Appointment appointment) {
        appointment.setId(IdUtil.simpleUUID());
        appointment.setIsDel(0);
        User user = userMapper.selectUserByName(appointment.getUser().getName());
        if (user == null){
            return 0;
        }
        appointment.setUserId(user.getId());
        return appointmentMapper.insertAppointment(appointment);
    }


    @Override
    public int insertCustomerAppointment(Appointment appointment) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        appointment.setId(IdUtil.simpleUUID());
        appointment.setIsDel(0);
        appointment.setUserId(currentUser.getId());
        appointment.setIsSuccessful(0);
        return appointmentMapper.insertAppointment(appointment);
    }

    @Override
    public int appointmentSuccess(String id) {
        return appointmentMapper.appointmentSuccess(id);
    }

    @Override
    public Appointment selectAppointmentById(String id) {
        return appointmentMapper.selectAppointmentById(id);
    }

    @Override
    public int updateAppointment(Appointment appointment) {
        User user = userMapper.selectUserByName(appointment.getUser().getName());
        if (user == null){
            return 0;
        }
        appointment.setUserId(user.getId());
        return appointmentMapper.updateAppointment(appointment);
    }

    @Override
    public int deleteAppointmentById(String id) {
        return appointmentMapper.deleteAppointmentById(id);
    }


}
