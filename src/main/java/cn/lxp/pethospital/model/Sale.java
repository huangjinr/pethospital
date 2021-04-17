package cn.lxp.pethospital.model;

public class Sale {
    private String drugId;
    private Integer count;
    private Double money;

    private Drug drug;

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "drugId='" + drugId + '\'' +
                ", count=" + count +
                ", money=" + money +
                ", drug=" + drug +
                '}';
    }
}
