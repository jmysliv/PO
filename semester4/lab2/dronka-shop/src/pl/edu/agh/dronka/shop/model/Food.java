package pl.edu.agh.dronka.shop.model;

import java.util.Date;

public class Food extends Item {
    private Date dateToEat;

    public Food(String name, Category category, int price, int quantity, Date date){
        super(name, category, price, quantity);
        this.dateToEat = date;
    }

    public Date getDateToEat() {
        return dateToEat;
    }

    public void setDateToEat(Date dateToEat) {
        this.dateToEat = dateToEat;
    }
}
