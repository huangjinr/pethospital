package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> selectAppointmentList();

    int insertAppointment(Appointment appointment);

    Appointment selectAppointmentById(String id);

    int updateAppointment(Appointment appointment);

    int deleteAppointmentById(String id);
}
