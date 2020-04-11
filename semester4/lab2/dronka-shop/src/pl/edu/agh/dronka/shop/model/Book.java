package pl.edu.agh.dronka.shop.model;

public class Book extends Item {
    private int numberOfPages;

    private boolean hardcover;

    public Book(String name, Category category, int price, int quantity, int numberOfPages, boolean hardcover){
        super(name, category, price, quantity);
        this.numberOfPages = numberOfPages;
        this.hardcover = hardcover;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isHardcover() {
        return hardcover;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }
}
