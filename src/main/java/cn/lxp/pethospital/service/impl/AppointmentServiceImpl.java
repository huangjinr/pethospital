package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.AppointmentMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.model.Appointment;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Appointment> selectAppointmentList() {
        return appointmentMapper.selectAppointmentList();
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
