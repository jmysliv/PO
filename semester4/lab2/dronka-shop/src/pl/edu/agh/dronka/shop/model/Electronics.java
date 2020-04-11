package pl.edu.agh.dronka.shop.model;

public class Electronics extends Item {
    private boolean mobile;

    private boolean guarantee;

    public Electronics(String name, Category category, int price, int quantity, boolean mobile, boolean guarantee){
        super(name, category, price, quantity);
        this.mobile = mobile;
        this.guarantee = guarantee;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
}
