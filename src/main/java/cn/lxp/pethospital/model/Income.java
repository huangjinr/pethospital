package cn.lxp.pethospital.model;

public class Income {

    private Integer count;
    private Double money;

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

    @Override
    public String toString() {
        return "Income{" +
                "count=" + count +
                ", money=" + money +
                '}';
    }
}
