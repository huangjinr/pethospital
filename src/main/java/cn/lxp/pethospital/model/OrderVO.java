package cn.lxp.pethospital.model;

public class OrderVO {

    private String id;
    private String drugName;
    private String userName;
    private Double totalPrice;
    private String animal;
    private String animalName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id='" + id + '\'' +
                ", drugName='" + drugName + '\'' +
                ", userName='" + userName + '\'' +
                ", totalPrice=" + totalPrice +
                ", animal='" + animal + '\'' +
                ", animalName='" + animalName + '\'' +
                '}';
    }
}
