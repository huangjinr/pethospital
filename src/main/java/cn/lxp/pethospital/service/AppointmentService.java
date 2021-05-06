package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> selectAppointmentList(String name,Integer isSuccessful);

    int insertAppointment(Appointment appointment);

    Appointment selectAppointmentById(String id);

    int updateAppointment(Appointment appointment);

    int deleteAppointmentById(String id);

    int insertCustomerAppointment(Appointment appointment);

    int appointmentSuccess(String id);
}
