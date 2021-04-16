package cn.lxp.pethospital.model;

public class Laboratory {

    private String id;
    private String userId;
    private String laboratoryReport;
    private String laboratoryImage;
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

    public String getLaboratoryReport() {
        return laboratoryReport;
    }

    public void setLaboratoryReport(String laboratoryReport) {
        this.laboratoryReport = laboratoryReport;
    }

    public String getLaboratoryImage() {
        return laboratoryImage;
    }

    public void setLaboratoryImage(String laboratoryImage) {
        this.laboratoryImage = laboratoryImage;
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
        return "Laboratory{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", laboratoryReport='" + laboratoryReport + '\'' +
                ", laboratoryImage='" + laboratoryImage + '\'' +
                ", isDel=" + isDel +
                ", user=" + user +
                '}';
    }
}
