package cn.lxp.pethospital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class Appointment {

    private String id;
    private String userId;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private String appointmentTime;
    private Integer isSuccessful;
    private String appointmentDetail;
    private Integer isDel;

    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Integer isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getAppointmentDetail() {
        return appointmentDetail;
    }

    public void setAppointmentDetail(String appointmentDetail) {
        this.appointmentDetail = appointmentDetail;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", isSuccessful=" + isSuccessful +
                ", appointmentDetail='" + appointmentDetail + '\'' +
                ", isDel=" + isDel +
                ", user=" + user +
                '}';
    }
}
