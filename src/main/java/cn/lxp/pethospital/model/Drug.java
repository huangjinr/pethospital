package cn.lxp.pethospital.model;

public class Drug {

    private String id;
    private String drugName;
    private Double drugPrice;
    private Integer drugSize;
    private String drugDetail;
    private String drugImage;
    private String drugType;
    private Integer isDel;


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

    public Double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getDrugSize() {
        return drugSize;
    }

    public void setDrugSize(Integer drugSize) {
        this.drugSize = drugSize;
    }

    public String getDrugDetail() {
        return drugDetail;
    }

    public void setDrugDetail(String drugDetail) {
        this.drugDetail = drugDetail;
    }

    public String getDrugImage() {
        return drugImage;
    }

    public void setDrugImage(String drugImage) {
        this.drugImage = drugImage;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugPrice=" + drugPrice +
                ", drugSize=" + drugSize +
                ", drugDetail='" + drugDetail + '\'' +
                ", drugImage='" + drugImage + '\'' +
                ", drugType='" + drugType + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
