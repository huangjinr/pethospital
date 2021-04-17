package cn.lxp.pethospital.model;

public class OrderDTO {

    private String id;
    private String buyId;
    private String userId;
    private String drugId;
    private Integer orderSize;
    private Integer isDel;

    private User user;
    private Drug drug;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public Integer getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(Integer orderSize) {
        this.orderSize = orderSize;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", buyId='" + buyId + '\'' +
                ", userId='" + userId + '\'' +
                ", drugId='" + drugId + '\'' +
                ", orderSize=" + orderSize +
                ", isDel=" + isDel +
                ", user=" + user +
                ", drug=" + drug +
                '}';
    }
}
