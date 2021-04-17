package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AppointmentMapper {
    List<Appointment> selectAppointmentList();

    int insertAppointment(Appointment appointment);

    Appointment selectAppointmentById(String id);

    int updateAppointment(Appointment appointment);

    int deleteAppointmentById(String id);
}
