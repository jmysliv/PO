package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
    private final String name;
    private final BigDecimal price;
    private double discount;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = 0;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithDiscount(){
        return price.multiply(new BigDecimal(1-this.discount));
    }

    public void setDiscount(double newDiscount){
        if(newDiscount > 1 || newDiscount < 0){
            throw new IllegalArgumentException();
        }
        this.discount = newDiscount;
    }

    public double getDiscount() {
        return discount;
    }
}
